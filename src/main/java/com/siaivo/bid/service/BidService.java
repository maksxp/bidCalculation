package com.siaivo.bid.service;

import com.siaivo.bid.model.Bid;
import com.siaivo.bid.model.User;

import java.util.Date;
import java.util.List;

public interface BidService {
    List<Bid> findBidsByUser(User user);
    Bid findBidById(int id);
    List<Bid> findBidsByStatus(String bidStatus);
    List<Bid> findBidsByDate(Date dateStart, Date dateEnd);
    void saveSalesBid(Bid bid);
    void saveLogistBid(Bid bid);
    void confirmBid(Bid bid);
    void editBid(Bid bid, int weight);
    List<Bid> allBidsList();
    List<Bid> inWorkBidsList();
    List<Bid> purchaseBidsList();
    List<Bid> logistBidsList();
    List<Bid> approvedBidsList();
}
