package finalProject.DAO.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@Column(name="book_no")
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookNo;
	@Column(name="title")
	private String title;
	@Column(name="pub_year")
	@Temporal(TemporalType.DATE)
	private Date pubYear;
	@Column(name="description")
	private String description;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
				name="bookauthors",
				joinColumns = { @JoinColumn(name="bookNo") },
				inverseJoinColumns =  { @JoinColumn(name = "authorNo") }
				)
	private List<Author> authors;
	
	
	public Book(int bookNo , String title , Date pubYear , String description) {
		this.bookNo = bookNo;
		this.title = title;
		this.pubYear = pubYear;
		this.description = description;
	}
	
	public Book() {
		
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
	public List<Author> getAuthors() {
		return authors;
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
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	
	
	public boolean hasAuthor(Author author) {
		for (Author bookAuthors: getAuthors()) {
			if (bookAuthors.getAuthorNo() == author.getAuthorNo()) {
				return true;
			}
		}
		return false;
	}
}
