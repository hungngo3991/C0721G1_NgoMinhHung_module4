package com.codegym.hoanthien_giohang.model;

import java.util.HashMap;
import java.util.Map;


public class Cart {

    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    //    check Cart method
    public boolean checkCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    //    select item in cart method
    public Map.Entry<Product, Integer> selectProductInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    //    add new Product method
    public void addProduct(Product product) {
        if (!checkCart(product)) {
            products.put(product, 1);
        } else {
            Map.Entry<Product, Integer> eProduct = selectProductInCart(product);
            Integer newQuantity = eProduct.getValue() + 1;
            products.replace(eProduct.getKey(), newQuantity);
        }
    }

    //    sub Product method
    public void subProduct(Product product) {
        if (!checkCart(product)) {
            products.remove(product, 1);
        } else {
            Map.Entry<Product, Integer> eProduct = selectProductInCart(product);
            Integer newQuantity = eProduct.getValue() - 1;
            products.replace(eProduct.getKey(), newQuantity);
        }
    }

    //    remove Product method
    public void removeProduct(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                products.remove(entry.getKey());
            }
        }
    }

    //     count the total method
    public Integer countTotal() {
        Integer total = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            total += entry.getValue();
        }
        return total;
    }

    //        count product method
    public Integer countProduct() {
        return products.size();
    }

    //        count payment method
    public double countPayment() {
        double payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (double) entry.getValue();
        }
        return payment;
    }

}
