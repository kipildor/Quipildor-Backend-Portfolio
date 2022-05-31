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
    private Persona perso;

    //Constructor
    public HabilidadDTO(long idHabilidad, String tecnologia, int porcentaje, int posicion, Persona perso) {
        this.idHabilidad = idHabilidad;
        this.tecnologia = tecnologia;
        this.porcentaje = porcentaje;
        this.posicion = posicion;
        this.perso = perso;
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

    public Persona getPerso() {
        return perso;
    }

    public void setPerso(Persona perso) {
        this.perso = perso;
    }

    //Método ToString
    @Override
    public String toString() {
        return "HabilidadDTO [idHabilidad=" + idHabilidad + ", perso=" + perso + ", porcentaje=" + porcentaje
                + ", posicion=" + posicion + ", tecnologia=" + tecnologia + "]";
    }

    



}
