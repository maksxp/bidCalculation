package com.siaivo.bid.repository;

import com.siaivo.bid.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("buyerRepository")
public interface BuyerRepository extends JpaRepository<Buyer, Long>{
	Buyer findByName(String name);
	Buyer findById(int id);
	Buyer findByCountry(String country);
}
