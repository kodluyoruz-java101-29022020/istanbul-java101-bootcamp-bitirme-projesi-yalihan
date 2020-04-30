package finalProject.business;

import java.util.List;

import finalProject.entities.Book;

public interface IBookService {
	List<Book> getAllBooks();
	void add(Book book);
	void update(Book book);
	Book getById(int id);
	int findMaxId();
}
