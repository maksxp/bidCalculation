package com.siaivo.bid.repository;

import com.siaivo.bid.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Long>{
	Product findByName(String name);
	Product findById(int id);
}
