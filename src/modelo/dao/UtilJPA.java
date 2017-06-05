package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilJPA {
	
	private UtilJPA() {
		super();
	}

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("banco");

	public static EntityManager criarEntityManager() {
		EntityManager manager = factory.createEntityManager();
		return manager;
	}
}
