package by.itacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookDetailController {

    @GetMapping("/bookDetail")
    public String bookInformationPage(){
        return "bookDetail";
    }
}
