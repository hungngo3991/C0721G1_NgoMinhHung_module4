package com.codegym.ungdung_dienthoai.service;

import com.codegym.ungdung_dienthoai.model.Smartphone;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();

    Optional<Smartphone> findById(Integer id);

    Smartphone save(Smartphone smartphone);

    void remove(Integer id);
}
