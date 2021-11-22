package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.ContractDetail;
import com.codegym.casestudy.repository.IContractDetailRepository;
import com.codegym.casestudy.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractDetailServiceImpl implements IContractDetailService {


    @Autowired
    private IContractDetailRepository contractDetailRepository;


    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public Optional<ContractDetail> findById(Long id) {
        return contractDetailRepository.findById(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(Long id) {
        contractDetailRepository.deleteById(id);
    }
}
