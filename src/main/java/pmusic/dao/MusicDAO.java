package pmusic.dao;

import java.util.List;

import javax.persistence.EntityManager;

import pmusic.dao.util.ConnectionFactory;
import pmusic.model.Music;

public class MusicDAO {

	public void persist(Music music) {
		EntityManager em = ConnectionFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(music);
		em.getTransaction().commit();
		em.close();
	}

	public void update(Music music) {
		EntityManager em = ConnectionFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(music);
		em.getTransaction().commit();
		em.close();
	}

	public Music findById(Integer id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		Music music = em.find(Music.class, id);
		em.close();
		return music;
	}

	public void remove(Integer id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		em.getTransaction().begin();
		Music music = em.find(Music.class, id);
		if (music != null)
			em.remove(music);
		em.getTransaction().commit();
		em.close();
	}

	public List<Music> all() {
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Music> all = em.createQuery("from Music", Music.class).getResultList();
		em.close();
		return all;
	}

}
