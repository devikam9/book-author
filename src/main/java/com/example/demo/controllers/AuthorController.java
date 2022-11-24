package com.example.demo.controllers;

import com.example.demo.domain.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //This is for returning authors.
    @RequestMapping("/authors")
    public String getAuthors(Model model) {

        model.addAttribute("authors",authorRepository.findAll());


        return "books/authors/list2";
    }
}
