package by.itacademy.controller;

import by.itacademy.entity.Book;
import by.itacademy.entity.Genre;
import by.itacademy.service.interfaces.BookService;
import by.itacademy.service.interfaces.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private GenreService genreService;

    @Autowired
    private BookService bookService;

    @ModelAttribute("genres")
    public List<Genre> genres() {
        return genreService.findAll();
    }

    @GetMapping("/book")
    public String openBookFormPage(Model model, Long genreId) {
        List<Book> books = null;
        if (genreId != null) {
            books = bookService.findAllByGenreId(genreId);
        } else {
            books = bookService.findAllBy(PageRequest.of(0, 5));
        }
        model.addAttribute("books", books);

        return "book";
    }

    @PostMapping("/book")
    public String saveBook(Book book) {
        System.out.println(book);
        return "book";
    }
}
