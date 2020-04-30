package finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import finalProject.business.IBookService;
import finalProject.entities.Book;

@RestController
@RequestMapping("/rest")
public class RestApiController {
	
	private IBookService iBookService;
	
	@Autowired
	public RestApiController(IBookService iBookService) {
		this.iBookService = iBookService;
	}
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return this.iBookService.getAllBooks();
	}
	public void add(Book book) {
		this.iBookService.add(book);
	}
	public void update(Book book) {
		this.iBookService.update(book);
	}
	@GetMapping("/books/{id}")
	public Book getById(@PathVariable int id) {
		return this.iBookService.getById(id);
	}
	public int findMaxId() {
		return this.iBookService.findMaxId();
	}
	
}
