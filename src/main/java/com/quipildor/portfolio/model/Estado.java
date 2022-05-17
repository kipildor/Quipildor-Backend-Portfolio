package com.quipildor.portfolio.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Estado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEstado;
    
    @Column(nullable = false)
    private String descripcion;

    // Relaciones
    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Educacion> listaEducacion;
    
    // Constructores
    public Estado() {
    }

    public Estado(int idEstado, String descripcion) {
        this.idEstado = idEstado;
        this.descripcion = descripcion;
    }
    
    
    
}
