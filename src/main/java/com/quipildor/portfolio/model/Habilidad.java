package com.quipildor.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Habilidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idHabilidad;
    
    private String tecnologia;
    
    private int porcentaje;
    private int posicion;

    // Relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    private Persona perso;
    
    
    // Constructores
    public Habilidad() {
    }

    public Habilidad(long idHabilidad, String tecnologia, int porcentaje, int posicion) {
        this.idHabilidad = idHabilidad;
        this.tecnologia = tecnologia;
        this.porcentaje = porcentaje;
        this.posicion = posicion;
    }
    
    
    
    
    
}
