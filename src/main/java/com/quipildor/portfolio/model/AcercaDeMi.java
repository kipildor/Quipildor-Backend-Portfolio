package com.quipildor.portfolio.model;

import javax.persistence.Column;
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
public class AcercaDeMi {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idParrafo;
    
    @Column(length = 2500)
    private String parrafo;
    
    private int posicion;

    // Relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    private Persona perso;
    
    // Constructores
    public AcercaDeMi() {
    }

    public AcercaDeMi(long idParrafo, String parrafo, int posicion) {
        this.idParrafo = idParrafo;
        this.parrafo = parrafo;
        this.posicion = posicion;
    }
    
        
    
}
