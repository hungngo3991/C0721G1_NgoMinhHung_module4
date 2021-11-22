package com.codegym.casestudy.controller;


import com.codegym.casestudy.dto.ContractDto;
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
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IEmployeeService employeeService;


    @ModelAttribute("customers")
    public Iterable<Customer> customers() {
        return customerService.findAll();
    }

    @ModelAttribute("services")
    public Iterable<Service> services() {
        return serviceService.findAll();
    }

    @ModelAttribute("employees")
    public Iterable<Employee> employees() {
        return employeeService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView createContractForm() {
        ModelAndView modelAndView = new ModelAndView("/contract/create");
        modelAndView.addObject("contractDto", new ContractDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("contractDto") ContractDto contractDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "contract/create";
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            contractService.save(contract);
            return "redirect:/home";
        }
    }


}
