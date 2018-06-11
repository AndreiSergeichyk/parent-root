package by.itacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonalAccount {

    @GetMapping("/personalAccount")
    public String personalAccountPage(Model model) {
        return "personalAccount";
    }
}
