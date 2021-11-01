package controller;


import model.EMail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")


public class EMailController {
    @GetMapping("")
    public ModelAndView showForm () {
        ModelAndView modelAndView = new ModelAndView("index");
        String[] languages = {"English", "Vietnamese", "Japanese", "Chinese"};
        int[] pageSize = {5, 10, 15, 25, 50, 100};
        modelAndView.addObject("email", new EMail());
        modelAndView.addObject("languages", languages);
        modelAndView.addObject("pageSize", pageSize);
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update (@ModelAttribute("email") EMail email) {
        ModelAndView modelAndView = new ModelAndView("index2");
        modelAndView.addObject("email", email);
        return modelAndView;
    }
}
