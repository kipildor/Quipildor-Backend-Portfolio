package com.quipildor.portfolio.interfaz;

import java.util.List;

import com.quipildor.portfolio.model.Educacion;

public interface IEducacionService {

    //Trae una lista con todos los registros de Educacion
    public List<Educacion> listarEducacion();

    //Crea un nuevo registro de nivel educativo cursado
    public void crearEducacion(Educacion educacion);

    //Borra un registro educativo que coincida con el ID
    public void borrarEducacion(Long id);

    //Trae el registro educativo que coincida con el ID
    public Educacion buscarEducacion(Long id);

    //Actualiza registro educativo
    public void actualizarEducacion(Educacion educacion);
    
    
}
