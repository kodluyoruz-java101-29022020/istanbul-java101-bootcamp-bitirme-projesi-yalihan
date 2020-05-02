package finalProject.DAO;

import java.util.List;

import finalProject.entities.Book;

public interface IBookDAO {
	List<Book> getAllBooks();
	void add(Book book);
	void update(Book book);
	List<Book> getByTitle(String title);
	Book getById(int bookNo);
	int findMaxId();
}
