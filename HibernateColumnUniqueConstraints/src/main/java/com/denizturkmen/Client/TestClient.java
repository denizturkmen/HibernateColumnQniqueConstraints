package com.denizturkmen.Client;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.denizturkmen.Entity.Author;
import com.denizturkmen.Entity.Book;
import com.denizturkmen.Util.HibernateUtil;

public class TestClient {
	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			Author  author = new Author();
			author.setFirstName("Denizs");
			author.setLastName("Türkmen");
			
			Book book1 = new Book();
			book1.setBookPrice(900.00);
			book1.setIsbn("4564566456s");
			book1.setTitle("Hibernate ");
			book1.setAuthor(author);
			
			Book book2 = new Book();
			book2.setBookPrice(600.00);
			book2.setIsbn("911-987654312");
			book2.setTitle("Hibernate In Action");
			book2.setAuthor(author);
			
			author.getBooks().add(book1);
			author.getBooks().add(book2);
			
			session.beginTransaction();
			
			session.save(author);
			session.getTransaction().commit();
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}
}