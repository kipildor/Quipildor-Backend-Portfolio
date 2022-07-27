package com.quipildor.portfolio.repository;

import com.quipildor.portfolio.model.ImgProy;

import java.util.List;

//import antlr.collections.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IImgProyRepository extends JpaRepository<ImgProy, Long> {

    @Query("select x from ImgProy x where x.proyecto_id = :var_param")
    public abstract List<ImgProy> listarImagenesDelProyecto(@Param("var_param")long idProyecto);
    
}
