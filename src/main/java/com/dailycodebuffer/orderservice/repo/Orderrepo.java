package com.dailycodebuffer.orderservice.repo;

import com.dailycodebuffer.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Orderrepo extends JpaRepository<Order,Long> {
}
