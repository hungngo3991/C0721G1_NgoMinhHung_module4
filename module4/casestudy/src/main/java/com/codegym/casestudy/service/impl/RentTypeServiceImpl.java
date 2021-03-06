package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.RentType;
import com.codegym.casestudy.repository.IRentTypeRepository;

import com.codegym.casestudy.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentTypeServiceImpl implements IRentTypeService {

    @Autowired
    private IRentTypeRepository rentTypeRepository;


    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public Optional<RentType> findById(Long id) {
        return rentTypeRepository.findById(id);
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public void remove(Long id) {
        rentTypeRepository.deleteById(id);
    }
}
