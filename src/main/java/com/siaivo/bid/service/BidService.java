package com.siaivo.bid.service;

import com.siaivo.bid.model.Bid;
import com.siaivo.bid.model.User;

import java.util.Date;
import java.util.List;

public interface BidService {
    List<Bid> findBidsByUser(User user);
    Bid findBidByBidId(int bidId);
    List<Bid> findBidsByStatus(String orderStatus);
    List<Bid> findBidsByDate(Date dateStart, Date dateEnd);
    void savePurchaseBid(Bid bid);
    void saveSalesBid(Bid bid);
//    void closeOrder(Bid order);
    void confirmBid(Bid bid);
    void editBid(Bid bid, int weight);
    List<Bid> allBidsList();
    List<Bid> inWorkBidsList();
    List<Bid> purchaseBidsList();
    List<Bid> approvedBidsList();
}
