package com.codegym.casestudy.repository;


import com.codegym.casestudy.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "select * from employee where employee_name like :employee_name and employee_phone like :employee_phone and position_id like :position_id", nativeQuery = true)
    Page<Employee> findAll(Pageable pageable, @Param("employee_name") String employee_name,
                           @Param("employee_phone") String employee_phone, @Param("position_id") String position_id);
}
