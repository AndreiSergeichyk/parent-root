package by.itacademy.controller;

import by.itacademy.entity.Author;
import by.itacademy.service.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CreateAuthorController {

    @Autowired
    private AuthorService authorService;

    @ModelAttribute("allAuthor")
    public List<Author> authors() {
        return authorService.findAll();
    }

    @GetMapping("/createAuthor")
    public String createAuthor(Model model){

        model.addAttribute("author", new Author());

        return "createAuthor";
    }

    @PostMapping("/saveAuthor")
    public String saveAuthor(Author author){

        authorService.save(author);

        return "redirect:createAuthor";
    }

    @GetMapping("/authorDelete")
    public String deleteAuthor(Model model, Author author){

        authorService.delete(author);

        return "redirect:createAuthor";
    }

}
