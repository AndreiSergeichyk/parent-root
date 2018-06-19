package by.itacademy.controller;

import by.itacademy.entity.Book;
import by.itacademy.entity.Genre;
import by.itacademy.service.interfaces.BookService;
import by.itacademy.service.interfaces.GenreService;
import by.itacademy.util.Letters;
import by.itacademy.util.PageUtil;
import by.itacademy.util.SearchManager;
import by.itacademy.util.SearchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    private static final int COUNT_BOOKS_ON_PAGE = 2;
    private static final int FIRST_PAGE = 1;

    @Autowired
    private GenreService genreService;

    @Autowired
    private BookService bookService;

    @ModelAttribute("genres")
    public List<Genre> genres() {
        return genreService.findAll();
    }

    @ModelAttribute("letters")
    public List<String> letters() {
        return Letters.getInstance().getLetters();
    }

    @ModelAttribute("searchManager")
    public SearchManager searchManager() {
        return new SearchManager();
    }

    @GetMapping("/book")
    public String book() {
        return "redirect:book/1";
    }

    @GetMapping("/book/{numberPage}")
    public String openBookPage(Model model, @PathVariable("numberPage") Integer numberPage) {
        Integer countBooks = bookService.countBooks();
        Integer countPages = PageUtil.getCountPages(countBooks, COUNT_BOOKS_ON_PAGE);

        if (numberPage > countPages) {
            numberPage = FIRST_PAGE;
        }

        List<Book> books = bookService.findAllBy(numberPage, COUNT_BOOKS_ON_PAGE);

        model.addAttribute("books", books);
        model.addAttribute("countBooks", countBooks);
        model.addAttribute("numberPage", numberPage);
        model.addAttribute("pageCountList", PageUtil.getPageCountList(countPages));

        return "book";
    }

    @GetMapping("/bookGenre/{genreName}/{numberPage}")
    public String openBookPageByGenre(Model model,
                                      @PathVariable("genreName") String genreName,
                                      @PathVariable("numberPage") Integer numberPage) {
        Integer countBooks = bookService.countBooksByGenreName(genreName);
        Integer countPages = PageUtil.getCountPages(countBooks, COUNT_BOOKS_ON_PAGE);

        if (numberPage > countPages) {
            numberPage = FIRST_PAGE;
        }

        List<Book> books = bookService.findAllByGenreName(genreName, numberPage, COUNT_BOOKS_ON_PAGE);

        model.addAttribute("books", books);
        model.addAttribute("genreName", genreName);
        model.addAttribute("numberPage", numberPage);
        model.addAttribute("pageCountList", PageUtil.getPageCountList(countPages));

        return "book";
    }

    @GetMapping("/bookLetter/{numberPage}/{searchLetter}")
    public String openBookPageByLetter(Model model,
                                       @PathVariable("searchLetter") String searchLetter,
                                       @PathVariable("numberPage") Integer numberPage) {
        Integer countBooks = bookService.countBooksByFirstLetter(searchLetter);
        Integer countPages = PageUtil.getCountPages(countBooks, COUNT_BOOKS_ON_PAGE);

        if (numberPage > countPages) {
            numberPage = FIRST_PAGE;
        }

        List<Book> books = bookService.findBooksByLetter(searchLetter, numberPage, COUNT_BOOKS_ON_PAGE);

        model.addAttribute("books", books);
        model.addAttribute("searchLetter", searchLetter);
        model.addAttribute("numberPage", numberPage);
        model.addAttribute("pageCountList", PageUtil.getPageCountList(countPages));

        return "book";
    }

    @PostMapping("/book")
    public String openBookPageBySearchString(Model model, String searchString,
                                             SearchType searchType, Integer numberPage) {
        Integer countPages = null;
        List<Book> books = null;
        if (SearchType.TITLE.equals(searchType)) {
            Integer countBooks = bookService.countBooksByBookName(searchString);
            countPages = PageUtil.getCountPages(countBooks, COUNT_BOOKS_ON_PAGE);
            if (numberPage == null || numberPage > countPages) {
                numberPage = FIRST_PAGE;
            }
            books = bookService.findBooksByName(searchString, numberPage, COUNT_BOOKS_ON_PAGE);
        } else {
            Integer countBooks = bookService.countBooksByAuthorName(searchString);
            countPages = PageUtil.getCountPages(countBooks, COUNT_BOOKS_ON_PAGE);
            if (numberPage == null || numberPage > countPages) {
                numberPage = FIRST_PAGE;
            }
            books = bookService.findAllByAuthor(searchString, numberPage, COUNT_BOOKS_ON_PAGE);
        }

        model.addAttribute("books", books);
        model.addAttribute("searchLetter", searchString);
        model.addAttribute("numberPage", numberPage);
        model.addAttribute("searchType", searchType);
        model.addAttribute("pageCountList", PageUtil.getPageCountList(countPages));

        return "book";
    }
}
