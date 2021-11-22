package com.codegym.casestudy.dto;

import com.codegym.casestudy.model.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDto implements Validator {

    private Long employeeId;

    @NotBlank(message = "Name cannot be blank")
    private String employeeName;

    @NotBlank(message = "Birthday cannot be blank")
    @Pattern(regexp = "^(?:19\\d{2}|20\\d{2})[-/.](?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])$",
            message = "Birthday must be in the correct format: DD/MM/YYYY")
    private String employeeBirthday;

    @NotBlank(message = "Id card cannot be blank")
    @Pattern(regexp = "^([0-9]{9})|([0-9]{12})$",
            message = "Id Card must be in the correct format: XXXXXXXXX or XXXXXXXXXXXX")
    private String employeeIdCard;

    @NotNull(message = "Salary cannot be blank")
    @Min(value = 1, message = "Salary must be a positive number")
    private Double employeeSalary;

    @NotBlank(message = "Phone cannot be blank")
    @Pattern(regexp = "^(0|(\\(84\\)\\+))+([9][0-1][0-9]{7})$",
            message = "Phone must be in the correct format: 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx")
    private String employeePhone;

    @NotBlank(message = "Email cannot be blank")
    @Pattern(regexp = "^(?:^|\\s)[\\w!#$%&'*+/=?^`{|}~-](\\.?[\\w!#$%&'*+/=?^`{|}~-]+)*@\\w+[.-]?\\w*\\.[a-zA-Z]{2,3}\\b$",
            message = "Email must be in the correct format")
    private String employeeEmail;

    private String employeeAddress;

    private Position position;

    private EducationDegree educationDegree;

    private Division division;

    private User user;

    List<Employee> employees = new ArrayList<>();

    private boolean checkIdCard;

    private boolean checkPhone;

    private boolean checkEmail;

    public EmployeeDto() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public boolean isCheckIdCard() {
        return checkIdCard;
    }

    public void setCheckIdCard(boolean checkIdCard) {
        this.checkIdCard = checkIdCard;
    }

    public boolean isCheckPhone() {
        return checkPhone;
    }

    public void setCheckPhone(boolean checkPhone) {
        this.checkPhone = checkPhone;
    }

    public boolean isCheckEmail() {
        return checkEmail;
    }

    public void setCheckEmail(boolean checkEmail) {
        this.checkEmail = checkEmail;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        for (Employee employee : employees) {
            if (employeeDto.checkIdCard) {
                if (employeeDto.getEmployeeIdCard().equals(employee.getEmployeeIdCard())) {
                    errors.rejectValue("employeeIdCard", "employeeIdCard.equals", "Id Card already exists!");
                }
            }
            if (employeeDto.checkPhone) {
                if (employeeDto.getEmployeePhone().equals(employee.getEmployeePhone())) {
                    errors.rejectValue("employeePhone", "employeePhone.equals", "Employee phone already exists!");
                }
            }
            if (employeeDto.checkEmail) {
                if (employeeDto.getEmployeeEmail().equals(employee.getEmployeeEmail())) {
                    errors.rejectValue("employeeEmail", "employeeEmail.equals", "Employee email already exists!");
                }
            }
        }
    }
}
