package finalProject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import finalProject.business.IBookService;
import finalProject.entities.Book;

@Controller
@RequestMapping("/thyme")
public class ThymeleafController {
	private IBookService iBookService;
	
	@Autowired
	public ThymeleafController(IBookService iBookService) {
		this.iBookService = iBookService;
	}

	@RequestMapping(value="/book/list",method=RequestMethod.GET)
	public String getAllBooks(Model model) {
		
		model.addAttribute("books", iBookService.getAllBooks());
		
		return "pages/thyme_book_list";
	}
	
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String getUpdatePage(@PathVariable(value="id") int id, Model model) {
		model.addAttribute("book", iBookService.getById(id));
		return "pages/thyme_book_update";
	}
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable(value="id") int id ,@Valid Book book, BindingResult result,Model model) {
		iBookService.update(book);
		model.addAttribute("books", iBookService.getAllBooks());
		return "pages/thyme_book_list";
	}

	
	@RequestMapping(value="/book/add",method=RequestMethod.GET)
	public String getAddPage(Book book) {
    	return "pages/thyme_book_add";
    }
	@RequestMapping(value="/book/add",method=RequestMethod.POST)
	public String add(Book bookContext, BindingResult result, Model model) {
		iBookService.add(bookContext);
        model.addAttribute("books",iBookService.getAllBooks());
        return "pages/thyme_book_list";
    }
}
