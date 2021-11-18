package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from customer where customer_name like :customer_name and customer_phone like :customer_phone and customer_type_id like :customer_type_id", nativeQuery = true)
    Page<Customer> findAll(Pageable pageable, @Param("customer_name") String customer_name,
                           @Param("customer_phone") String customer_phone, @Param("customer_type_id") String customer_type_id);
}