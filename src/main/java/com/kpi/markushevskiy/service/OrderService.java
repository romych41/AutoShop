package com.kpi.markushevskiy.service;

import com.kpi.markushevskiy.model.Order;
import com.kpi.markushevskiy.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findByNumber(int number){
        return orderRepository.findByNumber(number);
    }

    public void remove(Order order){
        orderRepository.delete(order);
    }

    public void save(Order order){
        orderRepository.save(order);
    }
}
