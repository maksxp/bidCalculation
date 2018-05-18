package com.siaivo.bid.service;

import com.siaivo.bid.model.Buyer;

import java.util.List;

public interface BuyerService {
    Buyer findById(int id) ;
    void saveBuyer(Buyer buyer);
    List<Buyer> listAllBuyers();
    Buyer findByName(String name);
    Buyer findByCountry(String country);
  }
