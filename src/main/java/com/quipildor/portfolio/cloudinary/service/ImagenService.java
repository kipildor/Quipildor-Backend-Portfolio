package com.quipildor.portfolio.cloudinary.service;

import com.quipildor.portfolio.cloudinary.entity.Imagen;
import com.quipildor.portfolio.cloudinary.repository.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImagenService {

    @Autowired
    ImagenRepository imagenRepository;

    public List<Imagen> list(){
        return imagenRepository.findByOrderById();
    }

    public Optional<Imagen> getOne(int id){
        return imagenRepository.findById(id);
    }

    public void save(Imagen imagen){
        imagenRepository.save(imagen);
    }

    public void delete(int id){
        imagenRepository.deleteById(id);
    }

    public boolean exists(int id){
        return imagenRepository.existsById(id);
    }
}
