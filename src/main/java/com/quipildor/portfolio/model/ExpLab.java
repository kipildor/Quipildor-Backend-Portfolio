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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class ExpLab {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idExp;
    
    private String nombreEmp;
    
    @Column(nullable = false)
    private int fechaIng;
    
    @Column(nullable = true)
    private int fechaSalida;
    
    @Column(length = 250)
    private String descripcion;
    
    private long idUrlLogo;

    private String urlLogo;

    // Relaciones
    /* @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = Access.WRITE_ONLY)
    @JoinColumn(name = "persona_id") */
    private long persona_id;

    // Constructores
    public ExpLab() {
    }

    public ExpLab(long idExp, String nombreEmp, int fechaIng, int fechaSalida, String descripcion,
            long idUrlLogo, String urlLogo, long persona_id) {
        this.idExp = idExp;
        this.nombreEmp = nombreEmp;
        this.fechaIng = fechaIng;
        this.fechaSalida = fechaSalida;
        this.descripcion = descripcion;
        this.idUrlLogo = idUrlLogo;
        this.urlLogo = urlLogo;
        this.persona_id = persona_id;
    }
/*
    public ExpLab(long idExp, String nombreEmp, Date fechaIng, Date fechaSalida, String descripcion, String urlLogo) {
        this.idExp = idExp;
        this.nombreEmp = nombreEmp;
        this.fechaIng = fechaIng;
        this.fechaSalida = fechaSalida;
        this.descripcion = descripcion;
        this.urlLogo = urlLogo;
    }
*/
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

    public int getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(int fechaIng) {
        this.fechaIng = fechaIng;
    }

    public int getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(int fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getIdUrlLogo() {
        return idUrlLogo;
    }

    public void setIdUrlLogo(long idUrlLogo) {
        this.idUrlLogo = idUrlLogo;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
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
        return "ExpLab [descripcion=" + descripcion + ", fechaIng=" + fechaIng + ", fechaSalida=" + fechaSalida
                + ", idExp=" + idExp + ", nombreEmp=" + nombreEmp + ", perso=" + persona_id + ", idUrlLogo=" + idUrlLogo
                + ", urlLogo=" + urlLogo + "]";
    }

        
}
