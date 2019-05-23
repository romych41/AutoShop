package com.kpi.markushevskiy.service;

import com.kpi.markushevskiy.model.Auth;
import com.kpi.markushevskiy.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public void add(String username, String authority){
        Auth auth = new Auth();
        auth.setUsername(username);
        auth.setAuthority(authority);
        authRepository.save(auth);
    }
}
