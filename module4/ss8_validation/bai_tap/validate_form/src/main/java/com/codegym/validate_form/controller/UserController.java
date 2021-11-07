package com.codegym.validate_form.controller;

import com.codegym.validate_form.model.User;
import com.codegym.validate_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;


    @GetMapping("")
    public ModelAndView listUser(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("users", userService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        new User().validate(user, bindingResult);
        if (!bindingResult.hasFieldErrors()) {
            userService.save(user);
        }
        return "/create";
    }
}
