package de.htw_berlin.MauMauG3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import datenmodell.Spiel;
import datenmodell.Spieler;
import datenmodell.Spielkarte;
import datenmodell.defaultData.createDefaultData;
import util.HibernateUtil;

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

		(new MauMauImpl()).beginneSpiel();

//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();

		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();

		for (Spielkarte spielkarte : createDefaultData.createDefaultSpielkarten()) {
			entityManager.persist(spielkarte);
		}

		Spiel spiel = new Spiel();

		for (int i = 0; i < 5; i++) {
			spiel.erstelleRunde();
			spiel.registriereSpieler(new Spieler());
		}

		entityManager.persist(spiel);
		
		entityManager.getTransaction().commit();

		entityManager.clear();

//		session.getTransaction().commit();
//
//		session.close();

	}
}
