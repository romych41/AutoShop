package com.kpi.markushevskiy.service;

import com.kpi.markushevskiy.model.Detail;
import com.kpi.markushevskiy.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailService {

    @Autowired
    private DetailRepository detailRepository;

    public List<Detail> findAll(){
        return detailRepository.findAll();
    }

    public List<Detail> findByCategory(String category){
        return detailRepository.findAllByCategory(category);
    }

    public Detail findById(Long id) {
        return detailRepository.findAllById(id);
    }
}
