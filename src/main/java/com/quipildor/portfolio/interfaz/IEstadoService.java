package com.quipildor.portfolio.interfaz;

import java.util.List;

import com.quipildor.portfolio.model.Estado;

public interface IEstadoService {

    //Trae una lista con todos los estados
    public List<Estado> listarEstados();

    //Trae un estado que coincida con el ID
    public Estado buscarEstado(Long id);
    
}
