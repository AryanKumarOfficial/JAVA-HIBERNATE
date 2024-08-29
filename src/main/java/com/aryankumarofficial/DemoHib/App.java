package com.aryankumarofficial.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		AlienName name = new AlienName();
		name.setfName("Aryan");
		name.setmName("Kumar");
		name.setlName("Singh");

		Alien aryan = new Alien();
		aryan.setAid(103);
		aryan.setAname(name);
		aryan.setColor("Red");

		Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);

		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(registry);
		Session session = sf.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(aryan);

		transaction.commit();

		System.out.println(aryan);
	}
}
