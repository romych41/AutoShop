package com.kpi.markushevskiy.service;

import com.kpi.markushevskiy.model.User;
import com.kpi.markushevskiy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User find(String username){
        return userRepository.findByUsername(username).size()!=0? userRepository.findByUsername(username).get(0) : null;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void add(User user){
        userRepository.save(user);
    }

    public void edit(User user){
        userRepository.save(user);
    }
}
