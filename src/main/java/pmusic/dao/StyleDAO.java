package pmusic.dao;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import pmusic.dao.util.ConnectionFactory;
import pmusic.model.Style;
import pmusic.util.PMusicException;

public class StyleDAO {

	public void persist(Style style) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(style);
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
	
	public Style findById(UUID id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		Style style;
		try {
			style = em.find(Style.class, id);
			em.close();
			return style;
		} catch (Exception e) {
			em.close();
			throw new PMusicException(400, "Ocorreu um erro ao persistir. Verifique se os dados estão corretos.");
		}
	}
	
	public List<Style> all() {
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Style> all = em.createQuery("from Style", Style.class).getResultList();
		em.close();
		return all;
	}



}
