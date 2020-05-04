package finalProject.DAO.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="authors")
public class Author {
	
	@Id
	@Column(name="author_no")
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authorNo;
	@Column(name="author_name")
	private String authorName;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
	private List<Book> books;
	
	public Author() {
		
	}
	
	public Author(int authorNo, String authorName, List<Book> books) {
		this.authorNo = authorNo;
		this.authorName = authorName;
		this.books = books;
	}
	
	public int getAuthorNo() {
		return authorNo;
	}
	public String getAuthorName() {
		return authorName;
	}
	public List<Book> getBooks() {
		return books;
	}
	
	public void setAuthorNo(int authorNo) {
		this.authorNo = authorNo;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
