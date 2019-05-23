package com.kpi.markushevskiy.repository;

import com.kpi.markushevskiy.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer> {
    List<Basket> findAllByOwner(String owner);
}
