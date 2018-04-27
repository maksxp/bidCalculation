package com.siaivo.bid.service;

import com.siaivo.bid.model.Product;

import java.util.List;

public interface ProductService {
    Product findById(int id) ;
    void saveProduct(Product product);
    List<Product> listAllProducts();
    Product findByName(String name);
  }
