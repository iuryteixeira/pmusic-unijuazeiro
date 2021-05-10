package pmusic.dao;

import java.util.List;

import javax.persistence.EntityManager;

import pmusic.dao.util.ConnectionFactory;
import pmusic.model.Music;
import pmusic.util.PMusicException;

public class MusicDAO {

	public void persist(Music music) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(music);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			if (em.isOpen() && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
			throw new PMusicException(400, "Ocorreu um erro ao persistir. Verifique se os dados estão corretos.");
		}

	}

	public void update(Music music) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(music);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			if (em.isOpen() && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
			throw new PMusicException(400, "Ocorreu um erro ao persistir. Verifique se os dados estão corretos.");
		}
	}

	public Music findById(Integer id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		Music music;
		try {
			music = em.find(Music.class, id);
			em.close();
			return music;
		} catch (Exception e) {
			em.close();
			throw new PMusicException(400, "Ocorreu um erro ao persistir. Verifique se os dados estão corretos.");
		}

	}

	public void remove(Integer id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			Music music = em.find(Music.class, id);
			if (music != null)
				em.remove(music);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			if (em.isOpen() && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
			throw new PMusicException(400, "Ocorreu um erro ao persistir. Verifique se os dados estão corretos.");
		}
	}

	public List<Music> all() {
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Music> all = em.createQuery("from Music", Music.class).getResultList();
		em.close();
		return all;
	}

	public Music findByName(String name) {
		EntityManager em = ConnectionFactory.createEntityManager();
		Music m = em.createQuery("select m from Music m where m.name = :nam", Music.class).setParameter("nam", name)
				.getSingleResult();
		em.close();
		return m;
	}

	public List<Music> findAllByName(String name) {
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Music> all = em.createQuery("select m from Music m where lower(m.name) like lower(:name)", Music.class)
				.setParameter("name", "%" + name + "%")
				.getResultList();
		em.close();
		return all;
	}

}
