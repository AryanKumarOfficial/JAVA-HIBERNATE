package com.aryankumarofficial.MappingDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Laptop laptop = new Laptop();
		laptop.setLid(101);
		laptop.setLname("Acer");

		Student student = new Student();
		student.setRollNo(1058);
		student.setName("Aryan");
		student.setMarks(50);
		student.setLaptop(laptop);

		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();

		SessionFactory factory = config.buildSessionFactory(registry);
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(laptop);
		session.save(student);

		transaction.commit();
	}
}
