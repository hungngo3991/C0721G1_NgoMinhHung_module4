package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType, Long> {
}
