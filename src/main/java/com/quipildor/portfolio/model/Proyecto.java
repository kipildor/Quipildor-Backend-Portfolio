package com.quipildor.portfolio.model;

import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idProyecto;
    
    @Column(nullable = false)
    private String nombreProy;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date fechaProy;
    
    private String descripcion;
    
    private String urlGithub;

    private String urlPropia;
    
    
    // Constructores
    public Proyecto() {
    }


    public Proyecto(long idProyecto, String nombreProy, Date fechaProy, String descripcion, String urlGithub,
            String urlPropia) {
        this.idProyecto = idProyecto;
        this.nombreProy = nombreProy;
        this.fechaProy = fechaProy;
        this.descripcion = descripcion;
        this.urlGithub = urlGithub;
        this.urlPropia = urlPropia;
    }

    
    
}
