package de.htw_berlin.MauMauG3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

public class Starter {

	private static final EntityManagerFactory entityManagerFactory;
	private static final String PERSISTENCE_UNIT_NAME = "my-persistence-unit";

	static {

		entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

	}

	public static EntityManager getEntityManager() {

		return entityManagerFactory.createEntityManager();

	}

	public static void main(String[] args) {

		(new MauMauImpl()).starteNeuesSpiel();

//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();

//		EntityManager entityManager = getEntityManager();
//		entityManager.getTransaction().begin();
//
//
//
//		entityManager.persist();
//
//		entityManager.getTransaction().commit();
//
//		entityManager.clear();

//		session.getTransaction().commit();
//
//		session.close();

	}
}
