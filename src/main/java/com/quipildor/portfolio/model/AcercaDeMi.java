package com.quipildor.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class AcercaDeMi {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idParrafo;
    
    @Column(length = 2500)
    private String parrafo;
    
    private int posicion;
    
    // Constructores
    public AcercaDeMi() {
    }

    public AcercaDeMi(long idParrafo, String parrafo, int posicion) {
        this.idParrafo = idParrafo;
        this.parrafo = parrafo;
        this.posicion = posicion;
    }
    
        
    
}
