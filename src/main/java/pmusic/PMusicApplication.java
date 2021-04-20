package pmusic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pmusic.model.Music;

public class PMusicApplication {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-unijuazeiro");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		/*
		 * SALVAR
		 * em.persist(new Music("Sambando do Pezinho", 2.56)); em.persist(new
		 * Music("Chorinho Rapidao", 1.30));
		 */
		
		
		Music m = em.find(Music.class, 2);
		
		System.out.println(m.getName());
		
		m.setTime(4.7);
		
		//atualiza
		//em.merge(m);
		
		em.remove(m);
		
		em.getTransaction().commit();
		
		em.close();
		
		emf.close();

	}

}
