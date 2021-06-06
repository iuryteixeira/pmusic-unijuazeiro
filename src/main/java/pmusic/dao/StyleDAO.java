package pmusic.dao;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import pmusic.dao.util.ConnectionFactory;
import pmusic.model.style.Style;

public class StyleDAO extends GenericDAO<Style, UUID> {

	public StyleDAO() {
		super(Style.class);
	}

	public List<Style> all() {
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Style> all = em.createQuery("from Style", Style.class).getResultList();
		em.close();
		return all;
	}

}
