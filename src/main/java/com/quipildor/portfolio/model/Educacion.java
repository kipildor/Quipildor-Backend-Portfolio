package com.quipildor.portfolio.model;

import java.util.Date;
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
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEduc;
    
    @Column(nullable = false)
    private String nombreInstit;
    
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    
    @Column(nullable = false)
    private String titulo;
    
    @Column(nullable = true)
    private String urlLogo;
    
    // Constructores

    public Educacion() {
    }

    public Educacion(long idEduc, String nombreInstit, Date fechaInicio, Date fechaFin, String titulo, String urlLogo) {
        this.idEduc = idEduc;
        this.nombreInstit = nombreInstit;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.titulo = titulo;
        this.urlLogo = urlLogo;
    }
    
    
    
}
