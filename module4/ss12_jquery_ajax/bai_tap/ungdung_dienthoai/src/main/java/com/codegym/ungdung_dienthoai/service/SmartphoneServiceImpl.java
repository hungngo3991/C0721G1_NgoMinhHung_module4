package com.codegym.ungdung_dienthoai.service;

import com.codegym.ungdung_dienthoai.model.Smartphone;
import com.codegym.ungdung_dienthoai.repository.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SmartphoneServiceImpl implements ISmartphoneService{

    @Autowired
    private ISmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Integer id) {
        return smartphoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    @Override
    public void remove(Integer id) {
        smartphoneRepository.deleteById(id);
    }
}
