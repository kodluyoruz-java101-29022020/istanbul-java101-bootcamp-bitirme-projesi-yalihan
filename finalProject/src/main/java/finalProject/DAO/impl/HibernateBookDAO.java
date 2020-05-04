package finalProject.DAO.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import finalProject.DAO.IBookDAO;
import finalProject.DAO.entity.Author;
import finalProject.DAO.entity.Book;

@Repository
public class HibernateBookDAO implements IBookDAO{
	
	private EntityManager entityManager;

	@Autowired
	public HibernateBookDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	
	@Override
	@Transactional
	public List<Book> getBooks() {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("from Book",finalProject.DAO.entity.Book.class).getResultList();
	}
	
	@Override
	@Transactional
	public List<Book> getBooksByTitle(String title) {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("from Book where title like '%"+title+"%'",Book.class).getResultList();
	}
	
	@Override
	@Transactional
	public Book getBookById(int bookNo) {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("from Book b where b.bookNo="+bookNo,Book.class).getSingleResult();
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
	public List<Author> getAuthors() {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("from Author",Author.class).getResultList();
	}	
	
	@Override
	@Transactional
	public Author getAuthorById(int authorNo) {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("from Author a where a.authorNo="+authorNo+"",Author.class).getSingleResult();
		
	}
}
