package finalProject.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.DAO.IBookDAO;
import finalProject.business.IBookService;
import finalProject.entities.Book;

@Service
public class BookManager implements IBookService {
	
	private IBookDAO iBookDAO;
	
	@Autowired
	public BookManager(IBookDAO iBookDAO) {
		this.iBookDAO = iBookDAO;
	}
	
	@Override
	@Transactional
	public List<Book> getAllBooks() {
		return this.iBookDAO.getAllBooks();
	}
	@Override
	@Transactional
	public void add(Book book) {
		this.iBookDAO.add(book);
	}
	@Override
	@Transactional
	public void update(Book book) {
		this.iBookDAO.update(book);
	}
	@Override
	@Transactional
	public Book getById(int id) {
		return this.iBookDAO.getById(id);
	}
	@Override
	@Transactional
	public int findMaxId() {
		return this.iBookDAO.findMaxId();
	}
}
