package controller;

import model.Medical;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.MedicalServiceImpl;

import java.util.List;

@Controller

public class MedicalController {

    private final MedicalServiceImpl medicalService = new MedicalServiceImpl();
    @GetMapping("/index")
    public String showIndex(Model model){
        model.addAttribute("medical",new Medical());
        return "/index";
    }

    @PostMapping("/index")
    public String createMedical(Medical medical, RedirectAttributes redirect){
        medical.setId((int) (Math.random() * 10000));
        medicalService.createMedical(medical);
        redirect.addFlashAttribute("success","Create successfully!");
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String showList(Model model){
        List<Medical> medicalList = medicalService.showListMedical();
        model.addAttribute("medicalList",medicalList);
        return "/list";
    }
}
