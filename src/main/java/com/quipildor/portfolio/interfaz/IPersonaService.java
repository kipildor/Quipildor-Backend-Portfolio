package com.quipildor.portfolio.interfaz;

import java.util.List;

import com.quipildor.portfolio.model.Persona;

public interface IPersonaService {
    
    //Trae una lista con toda las personas
    public List<Persona> listarPersonas();

    //Da de alta una persona
    public void crearPersona(Persona persona);

    //Borra a una persona
    public void borrarPersona(Long id);

    //Trae a la persona que coincide con el ID
    public Persona buscarPersonaPorID(Long id);

    //Actualiza los datos de una persona
    public void actualizarPersona(Persona persona);

    //Comprueba si existe o no la persona
    public boolean existePersonaId(Long id);
    
}
