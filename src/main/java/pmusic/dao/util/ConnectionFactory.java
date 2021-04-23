package pmusic.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private static EntityManagerFactory emf;

	private ConnectionFactory() {
	}

	public static EntityManager createEntityManager() {
		if (emf == null || !emf.isOpen())
			emf = Persistence.createEntityManagerFactory("unit-unijuazeiro");

		return emf.createEntityManager();
	}

	public static void close() {
		if (emf.isOpen())
			emf.close();
	}

}
