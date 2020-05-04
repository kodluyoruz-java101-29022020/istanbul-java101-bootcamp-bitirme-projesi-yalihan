package finalProject.business;

import java.util.List;

import finalProject.DAO.entity.*;

public interface IBookService {
	List<Book> getBooks();
	List<Book> getBooksByTitle(String title);
	Book getBookById(int id);
	
	void add(Book book);
	void update(Book book);
	
	List<Author> getAuthors();
	Author getAuthorById(int id);
}
