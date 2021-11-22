package com.codegym.casestudy.controller;


import com.codegym.casestudy.dto.ContractDetailDto;

import com.codegym.casestudy.model.*;
import com.codegym.casestudy.service.IAttachServiceService;
import com.codegym.casestudy.service.IContractDetailService;
import com.codegym.casestudy.service.IContractService;
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
@RequestMapping("/contractDetail")
public class ContractDetailController {

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private IAttachServiceService attachServiceService;


    @ModelAttribute("contracts")
    public Iterable<Contract> contracts() {
        return contractService.findAll();
    }

    @ModelAttribute("attachServices")
    public Iterable<AttachService> attachServices() {
        return attachServiceService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView createContractDetailForm() {
        ModelAndView modelAndView = new ModelAndView("/contractDetail/create");
        modelAndView.addObject("contractDetailDto", new ContractDetailDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("contractDetailDto") ContractDetailDto contractDetailDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "contractDetail/create";
        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            contractDetailService.save(contractDetail);
            return "redirect:/home";
        }
    }

}