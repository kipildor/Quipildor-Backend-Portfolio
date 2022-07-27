package com.quipildor.portfolio.service;

import java.util.List;

import com.quipildor.portfolio.interfaz.IEstadoService;
import com.quipildor.portfolio.model.Estado;
import com.quipildor.portfolio.repository.IEstadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpEstadoService implements IEstadoService {

    @Autowired IEstadoRepository iestadoRepo;

    @Override
    public List<Estado> listarEstados() {
        List<Estado> listaEstados = iestadoRepo.findAll();
        return listaEstados;
    }

    @Override
    public Estado buscarEstado(Integer id) {
        Estado estado = iestadoRepo.findById(id).orElse(null);
        return estado;
    }

    @Override
    public boolean existeEstado(int id) {
        return iestadoRepo.existsById(id);
    }

    @Override
    public void crearEstado(Estado estado) {
        iestadoRepo.save(estado);
        
    }
    
}
