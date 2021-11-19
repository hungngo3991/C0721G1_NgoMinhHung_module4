package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract, Long> {
}
