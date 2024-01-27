package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Person;

public class Program {

	public static void main(String[] args) {
		
		Person p1 = new Person(null, "Joao", "joao@email.com");
		Person p2 = new Person(null, "Marcelo", "marcelo@email.com");
		Person p3 = new Person(null, "Santos", "santos@email.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		System.out.println("Done!");
		
		Person p = em.find(Person.class, 2);
		System.out.println(p);
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("Done!");
		
		em.close();
		emf.close();

	}

}
