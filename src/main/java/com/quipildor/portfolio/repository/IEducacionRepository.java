package com.quipildor.portfolio.repository;

import com.quipildor.portfolio.model.Educacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Long> {
    
}
