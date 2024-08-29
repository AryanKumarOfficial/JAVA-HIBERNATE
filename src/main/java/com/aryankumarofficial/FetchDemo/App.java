package com.aryankumarofficial.FetchDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Laptop dell = new Laptop();
		dell.setLid(101);
		dell.setBrand("Dell");
		dell.setPrice(1000);

		Laptop mac = new Laptop();
		mac.setLid(102);
		mac.setBrand("Apple Macbook");
		mac.setPrice(2000);

		Laptop asus = new Laptop();
		asus.setLid(103);
		asus.setBrand("Asus");
		asus.setPrice(800);

		Laptop acer = new Laptop();
		acer.setLid(104);
		acer.setBrand("acer");
		acer.setPrice(1500);

		Laptop samsung = new Laptop();
		samsung.setLid(105);
		samsung.setBrand("Samsung");
		samsung.setPrice(1400);

		Alien aryan = new Alien();
		aryan.setAid(1);
		aryan.setAname("aryan");
		aryan.getLaptops().add(dell);
		aryan.getLaptops().add(asus);
		aryan.getLaptops().add(samsung);

		dell.setAlien(aryan);
		asus.setAlien(aryan);
		samsung.setAlien(aryan);

		Alien radha = new Alien();
		radha.setAid(2);
		radha.setAname("Radha");

		Alien mahesh = new Alien();
		mahesh.setAid(3);
		mahesh.setAname("Mahesh");
		mahesh.getLaptops().add(mac);
		mahesh.getLaptops().add(acer);

		mac.setAlien(mahesh);
		acer.setAlien(mahesh);

		Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class)
				.addAnnotatedClass(Laptop.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		SessionFactory factory = config.buildSessionFactory(registry);
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(dell);
		session.save(mac);
		session.save(asus);
		session.save(acer);
		session.save(samsung);

		session.save(aryan);
		session.save(radha);
		session.save(mahesh);

		transaction.commit();
	}
}
