package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Division, Long> {
}
