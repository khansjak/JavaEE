package com.control;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.to.Player;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateMain {

	public static void main(String[] args) {
		// Create Configuration
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(com.to.Player.class);

		// Create Standard Service Registry Builder
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());

		// Create a Session Factory
		SessionFactory factory = configuration.buildSessionFactory(builder.build());

		// Open the session
		Session session = factory.openSession();
		// Create Transaction
		Transaction transaction = session.beginTransaction();

		// HQL Queries
		//Query query = session.createQuery("from Player where playerName=:name");
		Query query = session.createQuery("from Player where age between :age1 and :age2");
		//query.setString("name", "Dhoni");
		query.setInteger("age1", 20);
		query.setInteger("age2", 45);
		List<Player> playerlist = query.list();
		System.out.println("Player Details ");
		for (Player p : playerlist) {
			System.out.println(p);
		}

		transaction.commit();

		// Close the session
		session.close();

	}

}

/*
 * 
 * Hibernate: insert into player_table (age, name, teamName) values (?, ?, ?)
 * Hibernate: insert into player_table (age, name, teamName) values (?, ?, ?)
 * Hibernate: select player0_.playerID as playerID1_0_0_, player0_.age as
 * age2_0_0_, player0_.name as name3_0_0_, player0_.teamName as teamName4_0_0_
 * from player_table player0_ where player0_.playerID=? The player details is
 * Player [playerID=1, playerName=Billy, teamName=Barcelona, age=30] Hibernate:
 * update player_table set age=?, name=?, teamName=? where playerID=?
 * 
 */
