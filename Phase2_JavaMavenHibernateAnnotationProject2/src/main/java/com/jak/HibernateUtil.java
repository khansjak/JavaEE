package com.jak;


import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.jak.entity.Student;



public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory  getSessionFactory() {
		if(sessionFactory == null) {
			try {
				Configuration cfg = new Configuration();
				Properties settings = new Properties();
				settings.put(Environment.URL,"jdbc:mysql://localhost:3306/simplilearn");
				settings.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
				settings.put(Environment.USER,"root");
				settings.put(Environment.PASS,"Jak@2019");
				settings.put(Environment.DIALECT,"org.hidernate.dialect.MySQLDialect");
				settings.put(Environment.SHOW_SQL,"true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
				settings.put(Environment.HBM2DDL_AUTO,"create-drop");
				cfg.setProperties(settings);
				
				cfg.addAnnotatedClass(Student.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
				sessionFactory = cfg.buildSessionFactory(serviceRegistry);
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		
		return sessionFactory;
	}
	
}

