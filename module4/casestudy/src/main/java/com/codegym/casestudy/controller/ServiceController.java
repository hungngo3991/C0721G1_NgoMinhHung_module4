package com.codegym.casestudy.controller;


import com.codegym.casestudy.model.*;
import com.codegym.casestudy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @Autowired
    private IRentTypeService rentTypeService;



    @ModelAttribute("serviceTypes")
    public Iterable<ServiceType> serviceTypes() {
        return serviceTypeService.findAll();
    }

    @ModelAttribute("rentTypes")
    public Iterable<RentType> rentTypes() {
        return rentTypeService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView createServiceForm() {
        ModelAndView modelAndView = new ModelAndView("/service/create");
        List<ServiceType> serviceTypeList = serviceTypeService.findAll();
        List<RentType> rentTypeList = rentTypeService.findAll();
        modelAndView.addObject("service", new Service());
        modelAndView.addObject("serviceTypeList", serviceTypeList);
        modelAndView.addObject("rentTypeList", rentTypeList);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Service service, @PageableDefault(value = 2) Pageable pageable) {
        serviceService.save(service);
        ModelAndView modelAndView = new ModelAndView("/service/create");

        List<Service> services = serviceService.findAll();
        modelAndView.addObject("services", services);
        modelAndView.addObject("message", "Create a new successful service!");
        return modelAndView;
    }
}
