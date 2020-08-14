package com.jak;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

	
	
public class HibernateUtil {
private static final SessionFactory sessionFactory;
	
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		catch(Exception e) {
			System.out.println("Session Factory could notf be created "+e.getMessage());
			throw new ExceptionInInitializerError();
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
