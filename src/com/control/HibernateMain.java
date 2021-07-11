package com.control;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.to.Player;
import com.to.Team;

public class HibernateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
		
		Configuration configuration= new Configuration().configure();
		configuration.addAnnotatedClass(com.to.Player.class);
		configuration.addAnnotatedClass(com.to.Team.class);
		StandardServiceRegistryBuilder builder=
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		
		SessionFactory factory= configuration.buildSessionFactory(builder.build());
		Session session=factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//Player p1= new Player(12,"Sammo","India",30);
		//Player p2= new Player(11,"Soumya","India",29);
		//session.save(p2);
		//session.save(p1);
		
		//Player p=session.get(Player.class, 10);
		//System.out.println("..... "+p);
		//p.setPlayerName("Nemo");
		
//		Player p1= new Player("Suditi","India",30);
//		Player p2= new Player("Babusona","India",26);
//		session.save(p2);
//		session.save(p1);
		
//		Query query = session.createQuery("from Player where playerName=:name");
//		query.setString("name", "sachin");
//		List<Player> playerList= query.list();
//		System.out.println("Player Detail");
//		for(Player p:playerList) {
//			System.out.println(p);
//		}
		
		Team t1= new Team("India");
		Player p1= new Player("Virat Kohli", t1, 20);
		session.save(t1);
		session.save(p1);
		
		transaction.commit();
		session.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

}
