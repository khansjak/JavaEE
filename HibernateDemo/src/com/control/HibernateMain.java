package com.control;

import org.hibernate.cfg.Configuration;

import com.to.Player;

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

		// Create data : Insert Operation
		// I have commented this Inserts because this will give error for
		// unique player id once created and run for another operations
		Player p1 = new Player("Billy", "Barcelona", 30);
		Player p2 = new Player("Neymar", "Qatar", 21);
		// Player p3 = new Player(30, "Charmender", "China", 26);
		// Save session : Uncomment for inserts
		session.save(p1);
		session.save(p2);
		// session.save(p3);

		// Read Data
		Player p = session.get(Player.class, 1);
		System.out.println("The player details is " + p);

		// Update
		p.setPlayerName("Dhoni");
		p.setAge(54);

		// Delete
		// session.delete(p);

		// Commit transaction
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
