package com.quipildor.portfolio.service;

import java.util.List;

import com.quipildor.portfolio.interfaz.IProyectoService;
import com.quipildor.portfolio.model.Proyecto;
import com.quipildor.portfolio.repository.IProyectoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpProyectoService implements IProyectoService {

    @Autowired IProyectoRepository iproyectoRepo;

    @Override
    public List<Proyecto> listarProyectos() {
        List<Proyecto> listaProyectos = iproyectoRepo.findAll();
        return listaProyectos;
    }

    @Override
    public void crearProyecto(Proyecto proyecto) {
        iproyectoRepo.save(proyecto);
        
    }

    @Override
    public void borrarProyecto(Long id) {
        iproyectoRepo.deleteById(id);
        
    }

    @Override
    public Proyecto buscarProyecto(Long id) {
        Proyecto proyecto = iproyectoRepo.findById(id).orElse(null);
        return proyecto;
    }

    @Override
    public void actualizarProyecto(Proyecto proyecto) {
        iproyectoRepo.save(proyecto);
        
    }
    
}
