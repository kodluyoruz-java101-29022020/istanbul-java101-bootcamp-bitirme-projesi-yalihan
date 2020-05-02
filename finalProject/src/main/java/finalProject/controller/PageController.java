package finalProject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import finalProject.business.IBookService;
import finalProject.entities.Book;

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
		model.addAttribute("books", iBookService.getAllBooks());
		return "pages/thyme_book_list";
	}
	@RequestMapping(value="/book/list",method=RequestMethod.POST)
	public String getSearchBook(Model model , @RequestParam(defaultValue="") String title) {
		model.addAttribute("books", iBookService.getByTitle(title));
		return "pages/thyme_book_search";
	}
	
	
	
	@RequestMapping(value="/edit/{bookNo}",method=RequestMethod.GET)
	public String getUpdatePage(@PathVariable(value="bookNo") int bookNo, Model model) {
		model.addAttribute("book", iBookService.getById(bookNo));
		return "pages/thyme_book_update";
	}
	@RequestMapping(value="/update/{bookNo}",method=RequestMethod.POST)
	public String update(@PathVariable(value="bookNo") int bookNo,@Valid Book book, BindingResult result,Model model) {
		iBookService.update(book);
		model.addAttribute("books", iBookService.getAllBooks());
		return "pages/thyme_book_list";
	}

	
	
	@RequestMapping(value="/book/add",method=RequestMethod.GET)
    public String getAddPage(Book book) {
    	return "pages/thyme_book_add";
    }
	@RequestMapping(value="/book/add",method=RequestMethod.POST)
    public String add(Book book, BindingResult result, Model model) {
		iBookService.add(book);
        model.addAttribute("books",iBookService.getAllBooks());
        return "pages/thyme_book_list";
    }
}
//