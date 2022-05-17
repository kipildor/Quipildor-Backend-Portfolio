package com.quipildor.portfolio.repository;

import com.quipildor.portfolio.model.Estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado, Integer> {
    
}
