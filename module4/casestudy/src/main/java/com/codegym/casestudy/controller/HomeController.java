package com.codegym.casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {

    @GetMapping(value = "/home")
    public String index() {
        return "home/index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

//    @GetMapping("/403")
//    public String accessDenied() {
//        return "403";
//    }
}
