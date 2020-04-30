package finalProject.entities;


import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@Column(name="id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="pubyear")
	private Date pubyear;
	@Column(name="description")
	private String description;
	
	public Book() {
		
	}

	public Book(int id, String title, Date pubyear, String description) {
		this.id = id;
		this.title = title;
		this.pubyear = pubyear;
		this.description = description;
	}

	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}

	public Date getPubyear() {
		return pubyear;
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
	public void setPubyear(Date pubyear) {
		this.pubyear = pubyear;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
