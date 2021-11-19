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
        List<Customer> customerList = customerService.findAll();
        List<Service> serviceList = serviceService.findAll();
        List<Employee> employeeList = employeeService.findAll();
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("customerList", customerList);
        modelAndView.addObject("serviceList", serviceList);
        modelAndView.addObject("employeeList", employeeList);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Contract contract, @PageableDefault(value = 2) Pageable pageable) {
        contractService.save(contract);
        ModelAndView modelAndView = new ModelAndView("/contract/create");

        List<Contract> contracts = contractService.findAll();
        modelAndView.addObject("contracts", contracts);
        modelAndView.addObject("message", "Create a new successful contract!");
        return modelAndView;
    }


}
