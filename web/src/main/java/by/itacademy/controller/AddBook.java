package by.itacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddBook {

    @GetMapping("/addBook")
    public String addBookFormPage(Model model) {
        return "addBook";
    }
}
