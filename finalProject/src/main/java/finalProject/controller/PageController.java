package finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import finalProject.DAO.entity.Author;
import finalProject.DAO.entity.Book;
import finalProject.business.IBookService;

@Controller
@RequestMapping("/thyme")
public class PageController {
	
	private IBookService iBookService;
	
	@Autowired
	public PageController(IBookService iBookService) {
		this.iBookService = iBookService;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value="/book/list",method=RequestMethod.GET)
	public String getAllBooks(Model model) {
		model.addAttribute("books", iBookService.getBooks());
		return "pages/thyme_book_list";
	}
	
	@RequestMapping(value="/book/list",method=RequestMethod.POST)
	public String getSearchBook(Model model , @RequestParam(defaultValue="") String title) {
		model.addAttribute("books",iBookService.getBooksByTitle(title));
		return "pages/thyme_book_search";
	}
	 
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value="/book/add",method=RequestMethod.GET)
	public String getAddPage(Book book,Model model) {
		model.addAttribute("authors",iBookService.getAuthors());
		return "pages/thyme_book_add";
	}
	
	@RequestMapping(value="/book/add",method=RequestMethod.POST)
	public String add(Book book,int bookNo,int authorNo,BindingResult result, Model model) {
		iBookService.add(book);
		model.addAttribute("books", iBookService.getBooks());
		return "pages/thyme_book_list";
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value="/edit/{bookNo}",method=RequestMethod.GET)
	public String getUpdatePage(@PathVariable(value="bookNo") int bookNo, Model model) {
		model.addAttribute("authors",iBookService.getAuthors());
			model.addAttribute("book", iBookService.getBookById(bookNo));
		return "pages/thyme_book_update";
	}
	
	@RequestMapping(value="/update/{bookNo}",method=RequestMethod.GET)
	public String update(@PathVariable(value="bookNo") int bookNo ,@RequestParam int authorNo, Model model) {
		Author author = iBookService.getAuthorById(authorNo);
		Book kitap = iBookService.getBookById(bookNo);
		
		if(kitap != null) {
			if(!kitap.hasAuthor(author)) {
				kitap.getAuthors().add(author);
			}
			iBookService.add(kitap);
			model.addAttribute("book",iBookService.getBookById(bookNo));
			model.addAttribute("authors",iBookService.getAuthors());
			model.addAttribute("books", iBookService.getBooks());
			return "pages/thyme_book_list";
		}
		model.addAttribute("books", iBookService.getBooks());
		return "pages/thyme_book_list";
	}
	
}