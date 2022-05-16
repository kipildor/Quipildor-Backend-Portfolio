package com.quipildor.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Estado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEstado;
    private String descripcion;
    
    // Constructores
    public Estado() {
    }

    public Estado(int idEstado, String descripcion) {
        this.idEstado = idEstado;
        this.descripcion = descripcion;
    }
    
    
    
}
