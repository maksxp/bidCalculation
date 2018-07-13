package com.siaivo.bid.service;

import com.siaivo.bid.model.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.siaivo.bid.model.User;
import com.siaivo.bid.repository.BidRepository;
import com.siaivo.bid.repository.UserRepository;

import java.util.*;

@Service("bidService")
public class BidServiceImpl implements BidService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BidRepository bidRepository;
    @Override
    public List <Bid> findBidsByUser(User user){
        List<Bid> bidsByUser = new ArrayList<>();
        List<Bid> list = bidRepository.findAll();
        ListIterator <Bid> iterator= list.listIterator();
        while (iterator.hasNext()) {
            Bid bid = iterator.next();
            if (bid.getUser().equals(user)) {
               bidsByUser.add(bid);
               }
        }
        return bidsByUser;}
   @Override
    public Bid findBidByBidId(int bidId){ return bidRepository.findByBidId(bidId);}
    @Override
    public List <Bid> findBidsByStatus(String bidStatus)
    {
        return bidRepository.findByStatusLike (bidStatus);
    }

    public List <Bid> findBidsByDate(Date dateStart, Date dateEnd){
        return bidRepository.findByCreationDateBetween(dateStart,dateEnd);
    }

    @Override
    public void savePurchaseBid(Bid bid) {
            bid.setStatus("У логіста");
            bidRepository.save(bid);
    }
    @Override
    public void saveSalesBid(Bid bid) {
        bid.setCreationDate(new Date());
        bid.setStatus("В закупках");
//        bid.setApproveDate(new Date());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user;
        user = userRepository.findByEmail(getEmail(principal));
        bid.setUser(user);
        bidRepository.save(bid);
    }
    @Override
    public List<Bid> allBidsList(){
        return bidRepository.findAll();
    }
    @Override
    public List<Bid> inWorkBidsList(){ return bidRepository.findByStatusNotLike("Погоджений");
    }
    @Override
    public List<Bid> purchaseBidsList(){ return bidRepository.findByStatusLike("В закупках");
    }
    @Override
    public List<Bid> approvedBidsList(){ return bidRepository.findByStatusLike("Погоджений");
    }
    @Override
    public void confirmBid(Bid bid) {
        bid.setApproveDate(new Date());
        bid.setStatus("В роботі");
        bidRepository.save(bid);
    }
    @Override
    public void editBid(Bid bid, int weight) {
        bid.setStatus("В роботі");
        bid.setApproveDate(new Date());
        bidRepository.save(bid);  }
//    @Override
//    public void closeBid(Bid bid) {
//        bid.setCloseDate(new Date());
//        bid.setStatus("Виконано");
//        bidRepository.save(bid);
//    }
    private static String getEmail (Object principal){
        if (principal instanceof UserDetails) {
            String email = ((UserDetails)principal).getUsername();
            return email;
        } else {
            String email = principal.toString();
            return email;
             }
    }
}
