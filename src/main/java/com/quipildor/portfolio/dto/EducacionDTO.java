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
    
    private String urlLogo;

    // Relaciones
    private Persona perso;

    private Estado estado;

    //Constructores
    public EducacionDTO(long idEduc, String nombreInstit, int fechaInicio, int fechaFin, String titulo,
            String urlLogo, Persona perso, Estado estado) {
        this.idEduc = idEduc;
        this.nombreInstit = nombreInstit;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.titulo = titulo;
        this.urlLogo = urlLogo;
        this.perso = perso;
        this.estado = estado;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    //Método ToString
    @Override
    public String toString() {
        return "EducacionDTO [estado=" + estado + ", fechaFin=" + fechaFin + ", fechaInicio=" + fechaInicio
                + ", idEduc=" + idEduc + ", nombreInstit=" + nombreInstit + ", perso=" + perso + ", titulo=" + titulo
                + ", urlLogo=" + urlLogo + "]";
    }

    

}
