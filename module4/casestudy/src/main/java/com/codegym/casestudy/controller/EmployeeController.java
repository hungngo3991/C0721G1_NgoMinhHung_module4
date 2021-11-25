package com.codegym.casestudy.controller;


import com.codegym.casestudy.dto.EmployeeDto;
import com.codegym.casestudy.model.*;

import com.codegym.casestudy.service.*;
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
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private IRoleService roleService;


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
        modelAndView.addObject("employeeDto", new EmployeeDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult) {
//        List<Role> roles = roleService.findAll();
//        User user = userService.findByUsername(employeeDto.getUser().getUsername());
//        employeeDto.getUser().setUserId(user.getUserId());
//        if (employeeDto.getPosition().getPositionId() == 5 || employeeDto.getPosition().getPositionId() == 6) {
//            for (Role role : roles) {
//                userService.addUserRole(employeeDto.getUser().getUserId(), role.getRoleId());
//            }
//        } else {
//            for (Role role : roles) {
//                if (role.getRoleId() == 1) {
//                    userService.addUserRole(employeeDto.getUser().getUserId(), role.getRoleId());
//                }
//            }
//        }
        employeeDto.setEmployees(employeeService.findAll());
        employeeDto.setCheckIdCard(true);
        employeeDto.setCheckPhone(true);
        employeeDto.setCheckEmail(true);
        employeeDto.validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            return "redirect:/employee";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee.get(), employeeDto);
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("/employee/edit");
        modelAndView.addObject("employeeDto", employeeDto);
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult) {
//        List<Employee> employees = employeeService.findAll();
        Optional<Employee> employeeOptional = employeeService.findById(employeeDto.getEmployeeId());
//        employeeDto.setUser(employeeOptional.get().getUser());
        String oldIdCard = employeeOptional.get().getEmployeeIdCard();
        String oldPhone = employeeOptional.get().getEmployeePhone();
        String oldEmail = employeeOptional.get().getEmployeeEmail();

        if (!oldIdCard.equals(employeeDto.getEmployeeIdCard())) {
            employeeDto.setEmployees(employeeService.findAll());
            employeeDto.setCheckIdCard(true);
            employeeDto.setCheckEmail(false);
            employeeDto.setCheckPhone(false);
            employeeDto.validate(employeeDto, bindingResult);
        }
        if (!oldPhone.equals(employeeDto.getEmployeePhone())) {
            employeeDto.setEmployees(employeeService.findAll());
            employeeDto.setCheckIdCard(false);
            employeeDto.setCheckEmail(false);
            employeeDto.setCheckPhone(true);
            employeeDto.validate(employeeDto, bindingResult);
        }
        if (!oldEmail.equals(employeeDto.getEmployeeEmail())) {
            employeeDto.setEmployees(employeeService.findAll());
            employeeDto.setCheckIdCard(false);
            employeeDto.setCheckEmail(true);
            employeeDto.setCheckPhone(false);
            employeeDto.validate(employeeDto, bindingResult);
        }


        if (bindingResult.hasFieldErrors()) {
            return "employee/edit";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            return "redirect:/employee";
        }
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
