package finalProject.business.model;

import finalProject.entities.Book;

public class Kitap {

	private Book book;
	private String authorName;
	
	public Kitap() {
		
	}
	
	public Kitap(Book book , String authorName) {
		this.book = book;
		this.authorName = authorName;
	}
	
	public Book getBook() {
		return book;
	}
	public String getAuthorName() {
		return authorName;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}
