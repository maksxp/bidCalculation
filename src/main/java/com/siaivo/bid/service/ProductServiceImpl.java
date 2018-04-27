package com.siaivo.bid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.siaivo.bid.model.Product;
import com.siaivo.bid.repository.ProductRepository;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Qualifier("productRepository")
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> listAllProducts(){   return productRepository.findAll() ;   }
    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);}
    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }
    @Override
    public Product findByName(String name) {return productRepository.findByName(name);}

}
