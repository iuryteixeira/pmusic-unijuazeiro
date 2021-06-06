package pmusic.dao;

import javax.persistence.EntityManager;

import pmusic.dao.util.ConnectionFactory;
import pmusic.model.MyEntity;
import pmusic.util.PMusicException;

public abstract class GenericDAO<T extends MyEntity, I extends Object> {

	protected Class<T> clazz;

	public GenericDAO(Class<T> clazz) {
		super();
		this.clazz = clazz;
	}

	public void persist(T entity) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(entity);
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

	public void update(T entity) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(entity);
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

	public void remove(Integer id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			T entity = em.find(clazz, id);
			if (entity != null)
				em.remove(entity);
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

	public T findById(I id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		T entity;
		try {
			entity = em.find(clazz, id);
			em.close();
			return entity;
		} catch (Exception e) {
			em.close();
			throw new PMusicException(400, "Ocorreu um erro ao persistir. Verifique se os dados estão corretos.");
		}

	}

}
