package com.quipildor.portfolio.service;

import java.util.List;

import com.quipildor.portfolio.interfaz.IEducacionService;
import com.quipildor.portfolio.model.Educacion;
import com.quipildor.portfolio.repository.IEducacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpEducacionService implements IEducacionService {

    @Autowired IEducacionRepository ieducRepo;

    @Override
    public List<Educacion> listarEducacion() {
        List<Educacion> listaEducacion = ieducRepo.findAll();
        return listaEducacion;
    }

    @Override
    public void crearEducacion(Educacion educacion) {
        ieducRepo.save(educacion);
        
    }

    @Override
    public void borrarEducacion(Long id) {
        ieducRepo.deleteById(id);
        
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        Educacion educ = ieducRepo.findById(id).orElse(null);
        return educ;
    }

    @Override
    public void actualizarEducacion(Educacion educacion) {
        ieducRepo.save(educacion);
        
    }

    @Override
    public boolean existeEducacion(Long id) {
        return ieducRepo.existsById(id);
    }

    
}
