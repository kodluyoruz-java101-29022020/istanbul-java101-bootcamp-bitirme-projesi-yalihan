package finalProject.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="pub_year")
	private LocalDate pubYear;
	@Column(name="description")
	private String description;
	
	public Book() {
		
	}

	public Book(int id, String title, LocalDate pubYear, String description) {
		this.id = id;
		this.title = title;
		this.pubYear = pubYear;
		this.description = description;
	}

	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}

	public LocalDate getPubYear() {
		return pubYear;
	}
	public String getDescription() {
		return description;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPubYear(LocalDate pubYear) {
		this.pubYear = pubYear;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
