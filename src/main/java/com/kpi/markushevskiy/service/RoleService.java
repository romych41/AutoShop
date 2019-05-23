package com.kpi.markushevskiy.service;

import com.kpi.markushevskiy.model.Role;
import com.kpi.markushevskiy.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role find(String name){
        return roleRepository.findAllByName(name).size()!=0? roleRepository.findAllByName(name).get(0): null;
    }
}
