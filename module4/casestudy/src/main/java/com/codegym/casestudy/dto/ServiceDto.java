package com.codegym.casestudy.dto;

import com.codegym.casestudy.model.RentType;
import com.codegym.casestudy.model.Service;
import com.codegym.casestudy.model.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

public class ServiceDto implements Validator {
    private Long serviceId;

    @NotBlank(message = "Service Code cannot be blank")
    @Pattern(regexp = "^(DV-)(\\d{4})$", message = "Service Code must be in the correct format: DV-XXXX")
    private String serviceCode;

    private String serviceName;

    private Integer serviceArea;

    @NotNull(message = "Service Cost cannot be blank")
    @Min(value = 1, message = "Service Cost must be a positive number")
    private Double serviceCost;

    private Integer serviceMaxPeople;

    private String standardRoom;

    private String descriptionOtherConvenience;

    private Double poolArea;

    @NotNull(message = "Number of Floors cannot be blank")
    @Min(value = 1, message = "Numbers of Floors must be a positive number")
    private Integer numberOfFloors;

    private ServiceType serviceType;

    private RentType rentType;


    List<Service> services = new ArrayList<>();

    private boolean checkCode;

    public ServiceDto() {
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public boolean isCheckCode() {
        return checkCode;
    }

    public void setCheckCode(boolean checkCode) {
        this.checkCode = checkCode;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDto serviceDto = (ServiceDto) target;
        for (Service service : services) {
            if (serviceDto.checkCode) {
                if (service.getServiceCode().equals(serviceDto.getServiceCode())) {
                    errors.rejectValue("serviceCode", "serviceCode.equals", "Service Code already exists!");
                }
            }
        }
    }
}
