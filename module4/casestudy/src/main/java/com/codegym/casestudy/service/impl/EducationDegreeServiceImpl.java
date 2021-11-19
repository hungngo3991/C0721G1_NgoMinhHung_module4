package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.EducationDegree;
import com.codegym.casestudy.repository.IEducationDegreeRepository;
import com.codegym.casestudy.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationDegreeServiceImpl implements IEducationDegreeService {


    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public Optional<EducationDegree> findById(Long id) {
        return educationDegreeRepository.findById(id);
    }

    @Override
    public void save(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree);
    }

    @Override
    public void remove(Long id) {
        educationDegreeRepository.deleteById(id);
    }
}
