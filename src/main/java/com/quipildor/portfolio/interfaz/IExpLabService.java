package com.quipildor.portfolio.interfaz;

import java.util.List;

import com.quipildor.portfolio.model.ExpLab;

public interface IExpLabService {
    
    //Trae una lista con todas las experiencias laborales
    public List<ExpLab> listarExpLab();

    //Da de alta un registro de experiencia laboral
    public void crearExpLab(ExpLab trabajo);

    //Borra un registro de experiencia laboral que coincide con el ID
    public void borrarExpLab(Long id);

    //Trae la experiencia laboral que coincide con el ID
    public ExpLab buscarExpLab(Long id);

    //Actualiza un registro de experiencia laboral
    public void actualizarExpLab(ExpLab trabajo);

    //Pregunta que la experiencia laboral que coincide con el ID existe o no
    public boolean existeExpLab(Long id);


}
