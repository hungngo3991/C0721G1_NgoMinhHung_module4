package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Long> {

}
