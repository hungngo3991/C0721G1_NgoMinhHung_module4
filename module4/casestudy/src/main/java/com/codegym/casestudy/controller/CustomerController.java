package com.codegym.casestudy.controller;

import com.codegym.casestudy.dto.CustomerDto;
import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.CustomerType;
import com.codegym.casestudy.service.ICustomerService;
import com.codegym.casestudy.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;

import java.util.Optional;


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


    public ModelAndView getList(@PageableDefault(2) Pageable pageable, @RequestParam(value = "customerName", defaultValue = "", required = false) String customerName,
                                @RequestParam(value = "customerPhone", defaultValue = "", required = false) String customerPhone,
                                @RequestParam(value = "customerTypeId", defaultValue = "", required = false) String customerTypeId) {
        Page<Customer> customers = customerService.findAll(pageable, customerName, customerPhone, customerTypeId);
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customerName", customerName);
        modelAndView.addObject("customerPhone", customerPhone);
        modelAndView.addObject("customerTypeId", customerTypeId);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }


    @GetMapping("")
    public ModelAndView listCustomer(
            @PageableDefault(value = 2) Pageable pageable,
            @RequestParam(value = "customerName", defaultValue = "", required = false) String customerName,
            @RequestParam(value = "customerPhone", defaultValue = "", required = false) String customerPhone,
            @RequestParam(value = "customerTypeId", defaultValue = "", required = false) String customerTypeId) {
        return getList(pageable, customerName, customerPhone, customerTypeId);
    }


    @GetMapping("/create")
    public ModelAndView createCustomerForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customerDto", new CustomerDto());
        return modelAndView;
    }


    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult) {
        customerDto.setCustomers(customerService.findAll());
        customerDto.setCheckCode(true);
        customerDto.setCheckIdCard(true);
        customerDto.setCheckPhone(true);
        customerDto.setCheckEmail(true);
        customerDto.validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            return "redirect:/customer";
        }
    }


    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer.get(), customerDto);
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customerDto", customerDto);
        return modelAndView;
    }


    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult) {
        Optional<Customer> customerOptional = customerService.findById(customerDto.getCustomerId());
        String oldCode = customerOptional.get().getCustomerCode();
        String oldIdCard = customerOptional.get().getCustomerIdCard();
        String oldPhone = customerOptional.get().getCustomerPhone();
        String oldEmail = customerOptional.get().getCustomerEmail();
        if (!oldCode.equals(customerDto.getCustomerCode())) {
            customerDto.setCustomers(customerService.findAll());
            customerDto.setCheckCode(true);
            customerDto.setCheckIdCard(false);
            customerDto.setCheckPhone(false);
            customerDto.setCheckEmail(false);
            customerDto.validate(customerDto, bindingResult);
        }
        if (!oldIdCard.equals(customerDto.getCustomerIdCard())) {
            customerDto.setCustomers(customerService.findAll());
            customerDto.setCheckCode(false);
            customerDto.setCheckIdCard(true);
            customerDto.setCheckPhone(false);
            customerDto.setCheckEmail(false);
            customerDto.validate(customerDto, bindingResult);
        }
        if (!oldPhone.equals(customerDto.getCustomerPhone())) {
            customerDto.setCustomers(customerService.findAll());
            customerDto.setCheckCode(false);
            customerDto.setCheckIdCard(false);
            customerDto.setCheckPhone(true);
            customerDto.setCheckEmail(false);
            customerDto.validate(customerDto, bindingResult);
        }
        if (!oldEmail.equals(customerDto.getCustomerEmail())) {
            customerDto.setCustomers(customerService.findAll());
            customerDto.setCheckCode(false);
            customerDto.setCheckIdCard(false);
            customerDto.setCheckPhone(false);
            customerDto.setCheckEmail(true);
            customerDto.validate(customerDto, bindingResult);
        }

        if (bindingResult.hasFieldErrors()) {
            return "customer/edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            return "redirect:/customer";
        }
    }


    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id, @PageableDefault(value = 2) Pageable pageable,
                               @RequestParam(value = "customerName", defaultValue = "", required = false) String customerName,
                               @RequestParam(value = "customerPhone", defaultValue = "", required = false) String customerPhone,
                               @RequestParam(value = "customerTypeId", defaultValue = "", required = false) String customerTypeId) {
        customerService.remove(id);
        return getList(pageable, customerName, customerPhone, customerTypeId);
    }


}
