package finalProject.entities;


import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@Column(name="book_no")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookNo;
	@Column(name="title")
	private String title;
	@Column(name="pub_year")
	private Date pubYear;
	@Column(name="description")
	private String description;
	
	public Book() {
		
	}

	public Book(int bookNo, String title, Date pubYear, String description) {
		this.bookNo = bookNo;
		this.title = title;
		this.pubYear = pubYear;
		this.description = description;
	}

	public int getBookNo() {
		return bookNo;
	}
	public String getTitle() {
		return title;
	}

	public Date getPubYear() {
		return pubYear;
	}
	public String getDescription() {
		return description;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPubYear(Date pubYear) {
		this.pubYear = pubYear;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
