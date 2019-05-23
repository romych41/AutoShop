package com.kpi.markushevskiy.repository;

import com.kpi.markushevskiy.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Integer> {
}
