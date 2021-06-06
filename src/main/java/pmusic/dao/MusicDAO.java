package pmusic.dao;

import java.util.List;

import javax.persistence.EntityManager;

import pmusic.dao.util.ConnectionFactory;
import pmusic.model.music.Music;

public class MusicDAO extends GenericDAO<Music, Integer> {

	public MusicDAO() {
		super(Music.class);
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
				.setParameter("name", "%" + name + "%").getResultList();
		em.close();
		return all;
	}

}
