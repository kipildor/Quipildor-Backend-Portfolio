package com.quipildor.portfolio.service;

import java.util.List;

import com.quipildor.portfolio.interfaz.IAcercaDeMiService;
import com.quipildor.portfolio.model.AcercaDeMi;
import com.quipildor.portfolio.repository.IAcercaDeMiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpAcercaDeMiService implements IAcercaDeMiService {

    @Autowired IAcercaDeMiRepository iacercaRepo;

    @Override
    public List<AcercaDeMi> listarParrafos() {
        List<AcercaDeMi> listaParrafos = iacercaRepo.findAll();
        return listaParrafos;
    }

    @Override
    public void crearParrafo(AcercaDeMi parrafo) {
        iacercaRepo.save(parrafo);
        
    }

    @Override
    public void borrarParrafo(Long id) {
        iacercaRepo.deleteById(id);
        
    }

    @Override
    public AcercaDeMi buscarParrafo(Long id) {
        AcercaDeMi parrafo = iacercaRepo.findById(id).orElse(null);
        return parrafo;
    }

    @Override
    public void actualizarParrafo(AcercaDeMi parrafo) {
        iacercaRepo.save(parrafo);
        
    }
    
}
