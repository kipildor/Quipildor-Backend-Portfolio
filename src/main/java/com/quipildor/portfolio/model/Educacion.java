package com.quipildor.portfolio.model;

import java.util.Date;
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
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEduc;
    
    @Column(nullable = false)
    private String nombreInstit;
    
    @Column(nullable = false)
    private int fechaInicio;
    
    @Column(nullable = true)
    private int fechaFin;
    
    @Column(nullable = false)
    private String titulo;
    
    private long idUrlLogo;
    
    @Column(nullable = true)
    private String urlLogo;

    // Relaciones
/*     @ManyToOne(fetch = FetchType.LAZY)
    //@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "persona_id")
    @JsonProperty(access = Access.WRITE_ONLY) */
    private long persona_id;

    /* @ManyToOne(fetch = FetchType.LAZY)
    //@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_id")
    @JsonProperty(access = Access.WRITE_ONLY) */
    private int estado_id;
    
    // Constructores
    public Educacion() {
    }

    public Educacion(long idEduc, String nombreInstit, int fechaInicio, int fechaFin, String titulo, 
                    long idUrlLogo, String urlLogo, long persona_id, int estado_id) {
        this.idEduc = idEduc;
        this.nombreInstit = nombreInstit;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.titulo = titulo;
        this.idUrlLogo = idUrlLogo;
        this.urlLogo = urlLogo;
        this.persona_id = persona_id;
        this.estado_id = estado_id;
    }
/*
    public Educacion(long idEduc, String nombreInstit, Date fechaInicio, Date fechaFin, String titulo, String urlLogo) {
        this.idEduc = idEduc;
        this.nombreInstit = nombreInstit;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.titulo = titulo;
        this.urlLogo = urlLogo;
    }
*/
    // Getters y Setters
    public long getIdEduc() {
        return idEduc;
    }

    public void setIdEduc(long idEduc) {
        this.idEduc = idEduc;
    }

    public String getNombreInstit() {
        return nombreInstit;
    }

    public void setNombreInstit(String nombreInstit) {
        this.nombreInstit = nombreInstit;
    }

    public int getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(int fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(int fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public int getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }

    //Método ToString
    @Override
    public String toString() {
        return "Educacion [estado=" + estado_id + ", fechaFin=" + fechaFin + ", fechaInicio=" + fechaInicio + ", idEduc="
                + idEduc + ", nombreInstit=" + nombreInstit + ", perso=" + persona_id + ", titulo=" + titulo + ", urlLogo="
                + urlLogo + "]";
    }
    
    
    
}
