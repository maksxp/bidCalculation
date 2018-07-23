package com.siaivo.bid.repository;

import com.siaivo.bid.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("bidRepository")
public interface BidRepository extends JpaRepository<Bid, Long> {
    Bid findById(int id);
    List<Bid> findByProduct(String product);
    List<Bid> findByStatusLike(String orderStatus);
    List<Bid> findByCreationDateBetween(Date dateStart, Date dateEnd);
    List<Bid> findByStatusNotLike(String orderStatus);
}