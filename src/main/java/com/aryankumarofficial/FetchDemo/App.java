package com.aryankumarofficial.FetchDemo;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		


		Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class)
				.addAnnotatedClass(Laptop.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		SessionFactory factory = config.buildSessionFactory(registry);
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Alien alien = (Alien) session.get(Alien.class, 1);

		System.out.println(alien.getAid());
		System.out.println(alien.getAname());

		Collection<Laptop> laps = alien.getLaptops();

		for (Laptop lap : laps) {
			System.out.println(lap);
		}

		transaction.commit();
	}
}
