package com.control;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.to.Player;
import com.to.Team;

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
		configuration.addAnnotatedClass(com.to.Team.class);

		// Create Standard Service Registry Builder
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());

		// Create a Session Factory
		SessionFactory factory = configuration.buildSessionFactory(builder.build());

		// Open the session
		Session session = factory.openSession();
		// Create Transaction
		Transaction transaction = session.beginTransaction();
		
		Team t1 = new Team("RCB");
		Team t2 = new Team("Hyderabad Sunrisers");
		Team t3 = new Team("Punjab King 11");
		Team t4 = new Team("Chennai Super Kings");
		
		Player p1 = new Player();
		p1.setAge(28);
		p1.setPlayerName("Virat Kohli");
		p1.getTeamList().add(t1);
		p1.getTeamList().add(t2);
		session.save(t1);
		session.save(t2);
		session.save(t3);
		session.save(t4);
		session.save(p1);
		
		/*
		 * Player p1 = new Player("Virat Kohli",t1,28); Player p2 = new
		 * Player("R Jadeja",t1,30); Player p3 = new Player("MS Dhoni",t1,47);
		 */
		
		
		
		/*
		 * session.save(p1); session.save(p2); session.save(p3);
		 */
		session.save(t1);
		
		// HQL Queries
		//Query query = session.createQuery("from Player where playerName=:name");
		//Query query = session.createQuery("from Player where age between :age1 and :age2");
		//query.setString("name", "Dhoni");
		//query.setInteger("age1", 20);
		//query.setInteger("age2", 45);
		//List<Player> playerlist = query.list();
		//System.out.println("Player Details ");
		//for (Player p : playerlist) {
		//	System.out.println(p);
		//}

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
