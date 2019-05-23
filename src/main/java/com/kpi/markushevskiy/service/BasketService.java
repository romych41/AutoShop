package com.kpi.markushevskiy.service;

import com.kpi.markushevskiy.model.Basket;
import com.kpi.markushevskiy.repository.BasketRepository;
import com.kpi.markushevskiy.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    @Autowired
    private BasketRepository basketRepository;

    public Basket findByOwner(String owner){
        List<Basket> basket = basketRepository.findAllByOwner(owner);
        return basket.size()==0? null : basket.get(0);
    }

    public void save(Basket basket){
        basketRepository.save(basket);
    }

    public void remove(Basket basket){
        basketRepository.delete(basket);
    }
}
