package com.codegym.casestudy.controller;


import com.codegym.casestudy.dto.ServiceDto;
import com.codegym.casestudy.model.*;
import com.codegym.casestudy.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


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
        modelAndView.addObject("serviceDto", new ServiceDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("serviceDto") ServiceDto serviceDto, BindingResult bindingResult) {
        serviceDto.setServices(serviceService.findAll());
        serviceDto.setCheckCode(true);
        serviceDto.validate(serviceDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "service/create";
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            serviceService.save(service);
            return "redirect:/home";
        }
    }
}
