package com.quipildor.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Habilidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idHabilidad;
    
    private String tecnologia;
    
    private int porcentaje;
    private int posicion;

    // Relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Persona perso;
    
    
    // Constructores
    public Habilidad() {
    }

    public Habilidad(long idHabilidad, String tecnologia, int porcentaje, int posicion, Persona perso) {
        this.idHabilidad = idHabilidad;
        this.tecnologia = tecnologia;
        this.porcentaje = porcentaje;
        this.posicion = posicion;
        this.perso = perso;
    }
/*
    public Habilidad(long idHabilidad, String tecnologia, int porcentaje, int posicion) {
        this.idHabilidad = idHabilidad;
        this.tecnologia = tecnologia;
        this.porcentaje = porcentaje;
        this.posicion = posicion;
    }
*/
    // Getters y Setters
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
        return "Habilidad [idHabilidad=" + idHabilidad + ", perso=" + perso + ", porcentaje=" + porcentaje
                + ", posicion=" + posicion + ", tecnologia=" + tecnologia + "]";
    }
    
    
    
    
    
}
