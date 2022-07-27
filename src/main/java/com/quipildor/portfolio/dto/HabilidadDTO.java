package com.quipildor.portfolio.dto;

import com.quipildor.portfolio.model.Persona;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HabilidadDTO {
    
    private long idHabilidad;
    
    private String tecnologia;
    
    private int porcentaje;

    private int posicion;

    // Relaciones
    private long persona_id;

    //Constructor
    public HabilidadDTO(long idHabilidad, String tecnologia, int porcentaje, int posicion, long persona_id) {
        this.idHabilidad = idHabilidad;
        this.tecnologia = tecnologia;
        this.porcentaje = porcentaje;
        this.posicion = posicion;
        this.persona_id = persona_id;
    }

    //Getters y Setters
    public long getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(long idHabilidad) {
        this.idHabilidad = idHabilidad;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public long getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(long persona_id) {
        this.persona_id = persona_id;
    }

    //Método ToString
    @Override
    public String toString() {
        return "HabilidadDTO [idHabilidad=" + idHabilidad + ", perso=" + persona_id + ", porcentaje=" + porcentaje
                + ", posicion=" + posicion + ", tecnologia=" + tecnologia + "]";
    }

    



}
