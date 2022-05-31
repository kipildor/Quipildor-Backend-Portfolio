package com.quipildor.portfolio.interfaz;

import java.util.List;

import com.quipildor.portfolio.model.Habilidad;

public interface IHabilidadService {

    //Trae una lista con las habilidades
    public List<Habilidad> listarHabilidades();

    //Da de alta una nueva habilidad
    public void crearHabilidad(Habilidad habilidad);
    
    //Borra una habilidad que coincida con el ID
    public void borrarHabilidad(Long id);

    //Trae la habilidad que coincida con el ID
    public Habilidad buscarHabilidadId(Long id);

    //Actualiza la habilidad que coincida con el ID
    public void actualizarHabilidad(Habilidad habilidad);

    //Comprobar si existe la habilidad
    public boolean existeHabilidad(Long id);
    
}
