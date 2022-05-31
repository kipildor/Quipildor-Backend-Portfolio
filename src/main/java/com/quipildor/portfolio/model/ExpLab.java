package com.quipildor.portfolio.model;

import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class ExpLab {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idExp;
    
    private String nombreEmp;
    
    @Temporal(TemporalType.DATE)
    private Date fechaIng;
    
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    
    @Column(length = 250)
    private String descripcion;
    
    private String urlLogo;

    // Relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    private Persona perso;

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

    //Getters y Setters
    public long getIdExp() {
        return idExp;
    }

    public void setIdExp(long idExp) {
        this.idExp = idExp;
    }

    public String getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    public Date getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Date fechaIng) {
        this.fechaIng = fechaIng;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
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
        return "ExpLab [descripcion=" + descripcion + ", fechaIng=" + fechaIng + ", fechaSalida=" + fechaSalida
                + ", idExp=" + idExp + ", nombreEmp=" + nombreEmp + ", perso=" + perso + ", urlLogo=" + urlLogo + "]";
    }

    
    
    
    
    
    
}
