package finalProject.DAO;

import java.util.List;

import finalProject.entities.Book;

public interface IBookDAO {
	List<Book> getAllBooks();
	void add(Book book);
	void update(Book book);
	void delete(Book book);
	Book getById(int id);
	int findMaxId();
}
