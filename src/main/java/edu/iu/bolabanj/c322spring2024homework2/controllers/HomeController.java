package edu.iu.bolabanj.c322spring2024homework2.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class HomeController {

    @GetMapping("/")
    public String greetings(){
        return "Welcome to the Guitar Center!";
    }
}
