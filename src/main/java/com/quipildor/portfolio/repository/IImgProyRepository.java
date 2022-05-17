package com.quipildor.portfolio.repository;

import com.quipildor.portfolio.model.ImgProy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImgProyRepository extends JpaRepository<ImgProy, Long> {
    
}
