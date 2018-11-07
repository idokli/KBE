package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

public class EntityManagerBeispiel {

	private static final EntityManagerFactory entityManagerFactory;
	private static final String PERSISTENCE_UNIT_NAME = "my-persistence-unit";

	static {

		entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

	}

	public static EntityManager getEntityManager() {

		return entityManagerFactory.createEntityManager();

	}

	public static void persist(Object o) {

//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();

		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();

		entityManager.persist(o);

		entityManager.getTransaction().commit();

		entityManager.clear();

//		session.getTransaction().commit();
//
//		session.close();

	}
}
