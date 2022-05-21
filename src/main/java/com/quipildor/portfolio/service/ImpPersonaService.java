package com.quipildor.portfolio.service;

import java.util.List;

import com.quipildor.portfolio.interfaz.IPersonaService;
import com.quipildor.portfolio.model.Persona;
import com.quipildor.portfolio.repository.IPersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService {

    @Autowired IPersonaRepository ipersoRepo;

    @Override
    public List<Persona> listarPersonas() {
        List<Persona> listaPerso = ipersoRepo.findAll();
        return listaPerso;
    }

    @Override
    public void crearPersona(Persona persona) {
        ipersoRepo.save(persona);
        
    }

    @Override
    public void borrarPersona(Long id) {
        ipersoRepo.deleteById(id);
        
    }

    @Override
    public Persona buscarPersonaPorID(Long id) {
        Persona perso = ipersoRepo.findById(id).orElse(null);
        return perso;
    }

    @Override
    public void actualizarPersona(Persona persona) {
        ipersoRepo.save(persona);
        
    }

    @Override
    public boolean existePersonaId(Long id) {
        return ipersoRepo.existsById(id);
    }
    
    
}
