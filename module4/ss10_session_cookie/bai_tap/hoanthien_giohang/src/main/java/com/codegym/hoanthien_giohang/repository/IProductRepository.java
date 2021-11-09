package com.codegym.hoanthien_giohang.repository;

import com.codegym.hoanthien_giohang.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
