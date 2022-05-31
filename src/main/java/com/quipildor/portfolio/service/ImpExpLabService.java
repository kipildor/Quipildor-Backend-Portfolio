package com.quipildor.portfolio.service;

import java.util.List;

import com.quipildor.portfolio.interfaz.IExpLabService;
import com.quipildor.portfolio.model.ExpLab;
import com.quipildor.portfolio.repository.IExpLabRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpExpLabService implements IExpLabService {

    @Autowired IExpLabRepository iexpLabRepo;

    @Override
    public List<ExpLab> listarExpLab() {
        List<ExpLab> listaEmpleos = iexpLabRepo.findAll();
        return listaEmpleos;
    }

    @Override
    public void crearExpLab(ExpLab empleo) {
        iexpLabRepo.save(empleo);
        
    }

    @Override
    public void borrarExpLab(Long id) {
        iexpLabRepo.deleteById(id);
        
    }

    @Override
    public ExpLab buscarExpLab(Long id) {
        ExpLab empleo = iexpLabRepo.findById(id).orElse(null);
        return empleo;
    }

    @Override
    public void actualizarExpLab(ExpLab empleo) {
        iexpLabRepo.save(empleo);
        
    }

    @Override
    public boolean existeExpLab(Long id) {
        return iexpLabRepo.existsById(id);
    }
    
}
