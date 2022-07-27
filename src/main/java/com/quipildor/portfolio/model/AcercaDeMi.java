package com.quipildor.portfolio.model;

import javax.persistence.Column;
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
public class AcercaDeMi {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idParrafo;
    
    @Column(length = 2500)
    private String parrafo;
    
    private int posicion;

    // Relaciones
    /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    @JsonProperty(access = Access.WRITE_ONLY) */
    private long persona_id;
    
    // Constructores
    public AcercaDeMi() {
    }
/*
    public AcercaDeMi(long idParrafo, String parrafo, int posicion) {
        this.idParrafo = idParrafo;
        this.parrafo = parrafo;
        this.posicion = posicion;
    }
*/
    public AcercaDeMi(long idParrafo, String parrafo, int posicion, long persona_id) {
        this.idParrafo = idParrafo;
        this.parrafo = parrafo;
        this.posicion = posicion;
        this.persona_id = persona_id;
    }

    // Getters y Setters
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
        return "AcercaDeMi [idParrafo=" + idParrafo + ", parrafo=" + parrafo + ", perso=" + persona_id + ", posicion="
                + posicion + "]";
    }
    
        
    
}
