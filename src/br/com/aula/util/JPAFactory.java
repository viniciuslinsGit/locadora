package br.com.aula.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAFactory {
	
	private static EntityManagerFactory emf = null;
	
	static {
		emf = Persistence.createEntityManagerFactory("aula_pos");
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void close(EntityManager em) {
		em.close();
	}

}
