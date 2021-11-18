package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;




public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> findAll (Pageable pageable, String customer_name, String customer_phone, String customer_type_id);


}
