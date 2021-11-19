package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service, Long> {
}
