package br.com.eumesmo.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil{
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	public void close() {
		emf.close();
	}
}
