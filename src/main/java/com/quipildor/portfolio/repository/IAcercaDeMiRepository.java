package com.quipildor.portfolio.repository;

import com.quipildor.portfolio.model.AcercaDeMi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAcercaDeMiRepository extends JpaRepository<AcercaDeMi, Long> {
    
}
