package com.codegym.ungdung_dienthoai.controller;

import com.codegym.ungdung_dienthoai.model.Smartphone;
import com.codegym.ungdung_dienthoai.service.SmartphoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/smartphones")
public class SmartphoneController {

    @Autowired
    private SmartphoneServiceImpl smartphoneService;

    @GetMapping("")
    public ModelAndView getPhoneList() {
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Smartphone> smartphones = smartphoneService.findAll();
        modelAndView.addObject("smartphones", smartphones);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("smartphone", new Smartphone());
        return modelAndView;
    }

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone save(@RequestBody Smartphone smartphone) {
        return smartphoneService.save(smartphone);
    }

    @GetMapping("{id}/edit")
    public ModelAndView editForm(@PathVariable("id") Integer id) {
        Optional<Smartphone> smartphone = smartphoneService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("smartphone", smartphone.get());
        return modelAndView;
    }

    @PostMapping(value = "{id}/edit", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone update(@PathVariable("id") Integer id, @RequestBody Smartphone smartphone) {
        smartphone.setId(id);
        return smartphoneService.save(smartphone);
    }

    @PostMapping(value = "{id}/delete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        smartphoneService.remove(id);
    }
}
