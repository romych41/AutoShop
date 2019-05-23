package com.kpi.markushevskiy.repository;

import com.kpi.markushevskiy.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {

    List<Detail> findAllByCategory(String category);

    Detail findAllById(Long id);
}
