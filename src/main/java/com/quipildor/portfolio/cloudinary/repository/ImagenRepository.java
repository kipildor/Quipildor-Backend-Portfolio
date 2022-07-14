package com.quipildor.portfolio.cloudinary.repository;

import com.quipildor.portfolio.cloudinary.entity.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.net.URL;
import java.util.List;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer> {
    List<Imagen> findByOrderById();

    Imagen getById(int id);

    boolean existsByName(String nombre);//

    /* boolean existsByImagenUrl(String url);//

    Imagen getByImagenUrl(String url);// */

    boolean existsByImagenId(String imgID);
}
