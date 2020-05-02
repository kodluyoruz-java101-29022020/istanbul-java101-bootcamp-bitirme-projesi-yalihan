package finalProject.DAO.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import finalProject.DAO.IBookDAO;
import finalProject.entities.Book;

@Repository
public class HibernateBookDAO implements IBookDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public HibernateBookDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	@Transactional
	public List<Book> getAllBooks() {
		Session session = entityManager.unwrap(Session.class);
		List<Book> books = session.createQuery("from Book",Book.class).getResultList();
		return books;
	}
	@Override
	@Transactional
	public void add(Book book) {
		Session session = entityManager.unwrap(Session.class);
		session.save(book);
	}
	@Override
	@Transactional
	public void update(Book book) {
		Session session = entityManager.unwrap(Session.class);
		session.update(book);
	}
	@Override
	@Transactional
	public List<Book> getByTitle(String title) {
		Session session = entityManager.unwrap(Session.class);
		String query = "from Book where title like '%"+title+"%'";
		return session.createQuery(query,Book.class).getResultList();
	}
	@Override
	@Transactional
	public Book getById(int bookNo) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Book.class, bookNo);
	}
	@Override
	@Transactional
	public int findMaxId() {
		Session session = entityManager.unwrap(Session.class);
		Book book = session.createQuery("select max(b.id) from Book b",Book.class).getSingleResult();
		return book.getBookNo();
	}
}
