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
public class ExpLab {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idExp;
    
    private String nombreEmp;
    
    @Temporal(TemporalType.DATE)
    private Date fechaIng;
    
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    
    @Column(length = 250)
    private String descripcion;
    
    private String urlLogo;

    // Constructores
    public ExpLab() {
    }

    public ExpLab(long idExp, String nombreEmp, Date fechaIng, Date fechaSalida, String descripcion, String urlLogo) {
        this.idExp = idExp;
        this.nombreEmp = nombreEmp;
        this.fechaIng = fechaIng;
        this.fechaSalida = fechaSalida;
        this.descripcion = descripcion;
        this.urlLogo = urlLogo;
    }

    
    
    
    
    
    
}
