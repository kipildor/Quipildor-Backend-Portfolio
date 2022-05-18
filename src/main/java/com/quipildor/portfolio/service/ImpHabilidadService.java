package com.quipildor.portfolio.service;

import java.util.List;

import com.quipildor.portfolio.interfaz.IHabilidadService;
import com.quipildor.portfolio.model.Habilidad;
import com.quipildor.portfolio.repository.IHabilidadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpHabilidadService implements IHabilidadService {

    @Autowired IHabilidadRepository ihabilidadRepo;

    @Override
    public List<Habilidad> listarHabilidades() {
        List<Habilidad> listaHabilidades = ihabilidadRepo.findAll();
        return listaHabilidades;
    }

    @Override
    public void crearHabilidad(Habilidad habilidad) {
        ihabilidadRepo.save(habilidad);
        
    }

    @Override
    public void borrarHabilidad(Long id) {
        ihabilidadRepo.deleteById(id);
        
    }

    @Override
    public Habilidad buscarHabilidad(Long id) {
        Habilidad habilidad = ihabilidadRepo.findById(id).orElse(null);
        return habilidad;
    }

    @Override
    public void actualizarHabilidad(Habilidad habilidad) {
        ihabilidadRepo.save(habilidad);
        
    }
    
}
