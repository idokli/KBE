package de.htw_berlin.MauMauG3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import datenmodell.Blatttyp;
import datenmodell.Blattwert;
import datenmodell.Spielkarte;
import util.HibernateUtil;

public class Starter 
{
	
    public static void main( String[] args ) {
    	
    	(new MauMauImpl()).beginneSpiel();
    	
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
         
        Spielkarte spielkarte = new Spielkarte(Blatttyp.Herz, Blattwert.Bube);
         
        session.save(spielkarte);
        session.getTransaction().commit();
         
        session.close();

    }
}
