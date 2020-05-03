package finalProject.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.DAO.IBookDAO;
import finalProject.business.IBookService;
import finalProject.business.model.Kitap;
import finalProject.entities.Author;

@Service
public class BookManager implements IBookService {
	
	private IBookDAO iBookDAO;
	
	@Autowired
	public BookManager(IBookDAO iBookDAO) {
		this.iBookDAO = iBookDAO;
	}
	@Override
	@Transactional
	//@MethodRunningTime(active = true)
	public List<Kitap> getKitaplar() {
		return this.iBookDAO.getKitaplar();
	}
	@Override
	@Transactional
	//@MethodRunningTime(active = true)
	public void add(Kitap kitap) {
		this.iBookDAO.add(kitap);
	}
	@Override
	@Transactional
	//@MethodRunningTime(active = true)
	public void update(Kitap kitap) {
		this.iBookDAO.update(kitap);
	}
	@Override
	@Transactional
	//@MethodRunningTime(active = true)
	public Kitap getById(int id) {
		return this.iBookDAO.getById(id);
	}
	@Override
	@Transactional
	//@MethodRunningTime(active = true)
	public List<Kitap> getByTitle(String title) {
		return this.iBookDAO.getByTitle(title);
	}
	@Override
	@Transactional
	public List<Author> getAuthors() {
		return this.iBookDAO.getAuthors();
	}
	@Override
	@Transactional
	//@MethodRunningTime(active = true)
	public int findMaxId() {
		return this.iBookDAO.findMaxId();
	}
}
