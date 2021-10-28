package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandWichController {

    @GetMapping(value = "/sandwich")
    public String sandwich() {
        return "/sandwich";
    }

    @PostMapping("/sandwich")
    public String save(@RequestParam(name = "spice") String[] spice, Model model) {
        model.addAttribute("spice", spice);
        return "/sandwich";
    }
}
