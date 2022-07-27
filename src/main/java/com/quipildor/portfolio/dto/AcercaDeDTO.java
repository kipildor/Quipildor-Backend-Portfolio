package com.quipildor.portfolio.dto;

import com.quipildor.portfolio.model.Persona;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AcercaDeDTO {

    private long idParrafo;
    
    private String parrafo;
    
    private int posicion;

    // **** Relaciones ****
    private long persona_id;
    //private Persona perso;

    //Constructores
    public AcercaDeDTO(long idParrafo, String parrafo, int posicion, long persona_id) {
        this.idParrafo = idParrafo;
        this.parrafo = parrafo;
        this.posicion = posicion;
        this.persona_id = persona_id;
    }

    //Getters y Setters
    public long getIdParrafo() {
        return idParrafo;
    }

    public void setIdParrafo(long idParrafo) {
        this.idParrafo = idParrafo;
    }

    public String getParrafo() {
        return parrafo;
    }

    public void setParrafo(String parrafo) {
        this.parrafo = parrafo;
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
        return "AcercaDeDTO [idParrafo=" + idParrafo + ", parrafo=" + parrafo + ", perso=" + persona_id + ", posicion="
                + posicion + "]";
    }

        
}
