package com.quipildor.portfolio.interfaz;

import java.util.*;

import com.quipildor.portfolio.model.Proyecto;

public interface IProyectoService {

    //Trae una lista con todos los proyectos
    public List<Proyecto> listarProyectos();

    //Crea un registro de un nuevo proyecto
    public void crearProyecto(Proyecto proyecto);

    //Borra un proyecto que coincida con el ID
    public void borrarProyecto(Long id);

    //Trae el proyecto que coincida con el ID
    public Proyecto buscarProyecto(Long id);

    //Actualiza un proyecto
    public void actualizarProyecto(Proyecto proyecto);

    //Comprueba si existe el proyecto
    public boolean existeProyecto(Long id);
    
    
}
