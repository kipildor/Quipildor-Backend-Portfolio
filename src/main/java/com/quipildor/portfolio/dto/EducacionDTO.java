package com.quipildor.portfolio.dto;

import java.util.Date;

import com.quipildor.portfolio.model.Estado;
import com.quipildor.portfolio.model.Persona;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EducacionDTO {
    
    private long idEduc;
    
    private String nombreInstit;
    
    private int fechaInicio;
    
    private int fechaFin;
    
    private String titulo;
    
    private long idUrlLogo;

    private String urlLogo;

    // Relaciones
    private long persona_id;

    private int estado_id;

    //Constructores
    public EducacionDTO(long idEduc, String nombreInstit, int fechaInicio, int fechaFin, String titulo,
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

    //Getters y Setters
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
        return "EducacionDTO [estado=" + estado_id + ", fechaFin=" + fechaFin + ", fechaInicio=" + fechaInicio
                + ", idEduc=" + idEduc + ", nombreInstit=" + nombreInstit + ", perso=" + persona_id + ", titulo=" + titulo
                + ", idUrlLogo=" + idUrlLogo + ", urlLogo=" + urlLogo + "]";
    }

    

}
