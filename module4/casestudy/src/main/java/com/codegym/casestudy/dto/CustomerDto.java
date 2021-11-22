package com.codegym.casestudy.dto;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;


public class CustomerDto implements Validator {

    private Long customerId;

    @NotBlank(message = "Customer Code cannot be blank")
    @Pattern(regexp = "^(KH-)(\\d{4})$", message = "Customer Code must be in the correct format: KH-XXXX")
    private String customerCode;

    @NotBlank(message = "Name cannot be blank")
    private String customerName;

    @NotBlank(message = "Birthday cannot be blank")
    @Pattern(regexp = "^(?:19\\d{2}|20\\d{2})[-/.](?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])$",
            message = "Birthday must be in the correct format: DD/MM/YYYY")
    private String customerBirthday;

    private Integer customerGender;

    @NotBlank(message = "Id card cannot be blank")
    @Pattern(regexp = "^([0-9]{9})|([0-9]{12})$",
            message = "Id Card must be in the correct format: XXXXXXXXX or XXXXXXXXXXXX")
    private String customerIdCard;

    @NotBlank(message = "Phone cannot be blank")
    @Pattern(regexp = "^(0|(\\(84\\)\\+))+([9][0-1][0-9]{7})$",
            message = "Phone must be in the correct format: 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx")
    private String customerPhone;

    @NotBlank(message = "Email cannot be blank")
    @Pattern(regexp = "^(?:^|\\s)[\\w!#$%&'*+/=?^`{|}~-](\\.?[\\w!#$%&'*+/=?^`{|}~-]+)*@\\w+[.-]?\\w*\\.[a-zA-Z]{2,3}\\b$",
            message = "Email must be in the correct format")
    private String customerEmail;

    private String customerAddress;


    private CustomerType customerType;


    List<Customer> customers = new ArrayList<>();


    private boolean checkCode;
    private boolean checkIdCard;
    private boolean checkPhone;
    private boolean checkEmail;


    public CustomerDto() {
    }

    public CustomerDto(Long customerId, String customerCode, String customerName, String customerBirthday, Integer customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public boolean isCheckCode() {
        return checkCode;
    }

    public void setCheckCode(boolean checkCode) {
        this.checkCode = checkCode;
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
        CustomerDto customerDto = (CustomerDto) target;
        for (Customer customer : customers) {
            if (customerDto.checkCode) {
                if (customer.getCustomerCode().equals(customerDto.getCustomerCode())) {
                    errors.rejectValue("customerCode", "customerCode.equals", "Customer Code already exists!");
                }
            }
            if (customerDto.checkIdCard) {
                if (customerDto.getCustomerIdCard().equals(customer.getCustomerIdCard())) {
                    errors.rejectValue("customerIdCard", "customerIdCard.equals", "Id Card already exists!");
                }
            }
            if (customerDto.checkPhone) {
                if (customerDto.getCustomerPhone().equals(customer.getCustomerPhone())) {
                    errors.rejectValue("customerPhone", "customerPhone.equals", "Customer phone already exists!");
                }
            }
            if (customerDto.checkEmail) {
                if (customerDto.getCustomerEmail().equals(customer.getCustomerEmail())) {
                    errors.rejectValue("customerEmail", "customerEmail.equals", "Customer email already exists!");
                }
            }
        }
    }
}
