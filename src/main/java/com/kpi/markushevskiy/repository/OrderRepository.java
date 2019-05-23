package com.kpi.markushevskiy.repository;

import com.kpi.markushevskiy.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByOwner(String owner);

    Order findByNumber(int number);
}
