package finalProject.DAO;

import java.util.List;

import finalProject.business.model.Kitap;
import finalProject.entities.Author;

public interface IBookDAO {
	List<Kitap> getKitaplar();
	void add(Kitap kitap);
	void update(Kitap kitap);
	Kitap getById(int id);
	List<Kitap> getByTitle(String title);
	public List<Author> getAuthors();
	int findMaxId();
}
