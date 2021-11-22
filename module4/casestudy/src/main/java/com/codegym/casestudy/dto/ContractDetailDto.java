package com.codegym.casestudy.dto;

import com.codegym.casestudy.model.AttachService;
import com.codegym.casestudy.model.Contract;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ContractDetailDto {

    private Long contractDetailId;

    @NotNull(message = "Quantity cannot be blank")
    @Min(value = 1, message = "Quantity must be a positive number")
    private Integer quantity;

    private Contract contract;

    private AttachService attachService;

    public ContractDetailDto() {
    }

    public Long getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Long contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
