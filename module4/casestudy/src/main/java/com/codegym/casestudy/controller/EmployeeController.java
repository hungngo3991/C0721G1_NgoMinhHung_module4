package com.codegym.casestudy.controller;


import com.codegym.casestudy.model.*;

import com.codegym.casestudy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IUserService userService;


    @ModelAttribute("positions")
    public Iterable<Position> positions() {
        return positionService.findAll();
    }

    @ModelAttribute("educationDegrees")
    public Iterable<EducationDegree> educationDegrees() {
        return educationDegreeService.findAll();
    }

    @ModelAttribute("divisions")
    public Iterable<Division> divisions() {
        return divisionService.findAll();
    }

    @ModelAttribute("users")
    public Iterable<User> users() {
        return userService.findAll();
    }


    public ModelAndView getList(@PageableDefault(2) Pageable pageable, @RequestParam(value = "employeeName", defaultValue = "", required = false)
            String employeeName, @RequestParam(value = "employeePhone", defaultValue = "", required = false) String employeePhone,
                                @RequestParam(value = "positionId", defaultValue = "", required = false) String positionId) {
        Page<Employee> employees = employeeService.findAll(pageable, employeeName, employeePhone, positionId);
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employeeName", employeeName);
        modelAndView.addObject("employeePhone", employeePhone);
        modelAndView.addObject("positionId", positionId);
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("")
    public ModelAndView listEmployee(
            @PageableDefault(value = 2) Pageable pageable,
            @RequestParam(value = "employeeName", defaultValue = "", required = false) String employeeName,
            @RequestParam(value = "employeePhone", defaultValue = "", required = false) String employeePhone,
            @RequestParam(value = "positionId", defaultValue = "", required = false) String positionId) {
        return getList(pageable, employeeName, employeePhone, positionId);
    }

    @GetMapping("/create")
    public ModelAndView createEmployeeForm() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        List<Position> positionList = positionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        List<Division> divisionList = divisionService.findAll();
        List<User> userList = userService.findAll();
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("positionList", positionList);
        modelAndView.addObject("educationDegreeList", educationDegreeList);
        modelAndView.addObject("divisionList", divisionList);
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Employee employee, @PageableDefault(value = 2) Pageable pageable) {
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        List<Employee> employees = employeeService.findAll();
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("message", "Create a new successful employee!");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView("/employee/edit");
        modelAndView.addObject("employee", employeeService.findById(id).get());

        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        List<Employee> employees = employeeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/employee/edit");
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("message", "Update employee successful!");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id, @PageableDefault(value = 2) Pageable pageable,
                               @RequestParam(value = "employeeName", defaultValue = "", required = false) String employeeName,
                               @RequestParam(value = "employeePhone", defaultValue = "", required = false) String employeePhone,
                               @RequestParam(value = "positionId", defaultValue = "", required = false) String positionId) {
        employeeService.remove(id);
        return getList(pageable, employeeName, employeePhone, positionId);
    }

}
