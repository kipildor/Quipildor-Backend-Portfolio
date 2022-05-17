package com.quipildor.portfolio.repository;

import com.quipildor.portfolio.model.ExpLab;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExpLabRepository extends JpaRepository<ExpLab, Long> {
    
}
