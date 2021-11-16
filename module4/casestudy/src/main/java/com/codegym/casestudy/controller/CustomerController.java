package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.CustomerType;
import com.codegym.casestudy.service.ICustomerService;
import com.codegym.casestudy.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @ModelAttribute("customerTypes")
    public Iterable<CustomerType> customerTypes() {
        return customerTypeService.findAll();
    }

    @GetMapping("")
    public ModelAndView listCustomer(
            @PageableDefault(value = 2, sort = "customerId", direction = Sort.Direction.ASC) Pageable pageable,
            @RequestParam(value = "customerName", defaultValue = "", required = false) String customerName,
            @RequestParam(value = "customerPhone", defaultValue = "", required = false) String customerPhone,
            @RequestParam(value = "customerType", defaultValue = "", required = false) String customerTypeId) {
        Page<Customer> customers = customerService.findAll(pageable, customerName, customerPhone, customerTypeId);
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customerName", customerName);
        modelAndView.addObject("customerPhone", customerPhone);
        modelAndView.addObject("customerType", customerTypeId);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createCustomerForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customerTypeList", customerTypeList);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Customer customer, @PageableDefault(value = 2) Pageable pageable) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create");

        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("message", "Create a new successful customer!");
        return modelAndView;
    }


}
