package com.siaivo.bid.repository;

import com.siaivo.bid.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findById(int id);
    List<Order> findByProduct(String product);
    List<Order> findByStatusLike(String orderStatus);
    List<Order> findByStartDateBetween(Date dateStart, Date dateEnd);
    List<Order> findByStatusNotLike(String orderStatus);
}