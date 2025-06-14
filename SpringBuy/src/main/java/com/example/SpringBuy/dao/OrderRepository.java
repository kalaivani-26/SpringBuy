package com.example.SpringBuy.dao;

import com.example.SpringBuy.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
