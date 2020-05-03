package finalProject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import finalProject.business.IBookService;
import finalProject.business.model.Kitap;
import finalProject.entities.Author;

@Controller
@RequestMapping("/thyme")
public class PageController {
	
	private IBookService iBookService;
	
	@Autowired
	public PageController(IBookService iBookService) {
		this.iBookService = iBookService;
	}

	@RequestMapping(value="/book/list",method=RequestMethod.GET)
	public String getAllBooks(Model model) {
		model.addAttribute("kitaplar", iBookService.getKitaplar());
		return "pages/thyme_book_list";
	}
	@RequestMapping(value="/book/list",method=RequestMethod.POST)
	public String getSearchBook(Model model , @RequestParam(defaultValue="") String title) {
		model.addAttribute("kitaplar", iBookService.getByTitle(title));
		return "pages/thyme_book_search";
	}
	
	
	@RequestMapping(value="/book/add",method=RequestMethod.GET)
	public String getAddPage(Kitap kitap) {
		return "pages/thyme_book_add";
	}
	@RequestMapping(value="/book/add",method=RequestMethod.POST)
	public String add(Kitap kitap, Author author, BindingResult result, Model model) {
		iBookService.add(kitap);
		model.addAttribute("kitaplar",iBookService.getKitaplar());
		return "pages/thyme_book_list";
	}
	
	
	@RequestMapping(value="/edit/{bookNo}",method=RequestMethod.GET)
	public String getUpdatePage(@PathVariable(value="bookNo") int bookNo, Model model) {
		model.addAttribute("kitap", iBookService.getById(bookNo));
		return "pages/thyme_book_update";
	}
	@RequestMapping(value="/update/{bookNo}",method=RequestMethod.POST)
	public String update(@PathVariable(value="bookNo") int bookNo ,@Valid Kitap kitap, BindingResult result,Model model) {
		iBookService.update(kitap);
		model.addAttribute("kitaplar", iBookService.getKitaplar());
		return "pages/thyme_book_list";
	}
}