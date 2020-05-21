package controller;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.to.Actors;

public class HibernateMain3 {

	public static void main(String[] args) {
		
		//Create configuration
		Configuration configuration = new Configuration().configure();
		
		//Attach configuration to Annotated class
		configuration.addAnnotatedClass(com.to.Actors.class);
		
		//Create Standard Services
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		
		//Create a Session Factory Attach to configuration and builder
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		//Open the session 
		Session session = factory.openSession();
		
		//Create Transaction 
		Transaction transaction = session.beginTransaction();
		
		//Create data : Insert Operation
		Actors a1 = new Actors(1,"Shahrukh",39,"K3G");
		session.save(a1);
		
		transaction.commit();
		session.close();
		
		

	}

}
