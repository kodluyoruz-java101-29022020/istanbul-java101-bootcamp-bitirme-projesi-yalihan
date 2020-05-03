package finalProject.DAO.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import finalProject.DAO.IBookDAO;
import finalProject.business.model.Kitap;
import finalProject.entities.Author;
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
	public List<Kitap> getKitaplar() {
		Session session = entityManager.unwrap(Session.class);
		String query = "SELECT new finalProject.business.model.Kitap(b,baut.authorName) FROM Book b "
				+ "LEFT OUTER JOIN b.authors baut group by b.title";
		List<Kitap> kitaplar = session.createQuery(query,Kitap.class).getResultList();
		return kitaplar;
	}
	@Override
	@Transactional
	public void add(Kitap kitap) {
		Session session = entityManager.unwrap(Session.class);
		session.save(kitap);
	}
	@Override
	@Transactional
	public void update(Kitap kitap) {
		Session session = entityManager.unwrap(Session.class);
		session.update(kitap.getBook());
	}
	@Override
	@Transactional
	public Kitap getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		String query = "SELECT new finalProject.business.model.Kitap(b,baut.authorName) FROM Book b "
				+ "LEFT OUTER JOIN b.authors baut where b.bookNo="+id+"";
		return session.createQuery(query,Kitap.class).getSingleResult();
		
	}
	@Override
	@Transactional
	public List<Kitap> getByTitle(String title) {
		Session session = entityManager.unwrap(Session.class);
		String query = "from Book where title like '%"+title+"%'";
		return session.createQuery(query,Kitap.class).getResultList();
	}
	@Override
	@Transactional
	public List<Author> getAuthors() {
		Session session = entityManager.unwrap(Session.class);
		String query = "from Author";
		return session.createQuery(query,Author.class).getResultList();
	}	
	@Override
	@Transactional
	public int findMaxId() {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("select MAX(id) from Book",Book.class).getSingleResult().getBookNo();
	}
}
