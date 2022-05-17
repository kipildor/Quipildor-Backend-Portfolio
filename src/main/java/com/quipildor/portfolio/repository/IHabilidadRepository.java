package com.quipildor.portfolio.repository;

import com.quipildor.portfolio.model.Habilidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabilidadRepository extends JpaRepository<Habilidad, Long> {
    
}
