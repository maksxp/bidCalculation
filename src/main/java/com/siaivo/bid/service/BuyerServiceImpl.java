package com.siaivo.bid.service;

import com.siaivo.bid.model.Buyer;
import com.siaivo.bid.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("buyerService")
public class BuyerServiceImpl implements BuyerService {

    @Qualifier("buyerRepository")
    @Autowired
    private BuyerRepository buyerRepository;

    @Override
    public List<Buyer> listAllBuyers(){   return buyerRepository.findAll() ;   }
    @Override
    public void saveBuyer(Buyer buyer) {
        buyerRepository.save(buyer);}
    @Override
    public Buyer findById(int id) {
        return buyerRepository.findById(id);
    }
    @Override
    public Buyer findByName(String name) {return buyerRepository.findByName(name);}
    @Override
    public Buyer findByCountry(String country) {return buyerRepository.findByCountry(country);}
}
