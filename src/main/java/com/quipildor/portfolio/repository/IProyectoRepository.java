package com.quipildor.portfolio.repository;

import com.quipildor.portfolio.model.Proyecto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Long> {
    
}
