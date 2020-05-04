package finalProject.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.DAO.IBookDAO;
import finalProject.DAO.entity.*;
import finalProject.business.IBookService;

@Service
public class BookManager implements IBookService {
	
	private IBookDAO iBookDAO;
	
	@Autowired
	public BookManager(IBookDAO iBookDAO) {
		this.iBookDAO = iBookDAO;
	}
	@Override
	@Transactional
	public List<Book> getBooks() {
		return this.iBookDAO.getBooks();
	}
	
	@Override
	@Transactional
	public List<Book> getBooksByTitle(String title) {
		return this.iBookDAO.getBooksByTitle(title);
	}
	
	@Override
	@Transactional
	public Book getBookById(int bookNo) {
		return this.iBookDAO.getBookById(bookNo);
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
	public List<Author> getAuthors() {
		return this.iBookDAO.getAuthors();
	}	
	
	@Override
	@Transactional
	public Author getAuthorById(int authorNo) {
		return this.iBookDAO.getAuthorById(authorNo);
		
	}
}
