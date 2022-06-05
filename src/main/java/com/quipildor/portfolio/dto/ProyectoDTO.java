package com.quipildor.portfolio.dto;

import java.util.Date;

import com.quipildor.portfolio.model.Persona;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProyectoDTO {

    private long idProyecto;
    
    private String nombreProy;
    
    private int fechaProy;
    
    private String descripcion;
    
    private String urlGithub;

    private String urlPropia;

    private String tecnologia;

    // Relaciones
    private Persona perso;

    //Constructores
    public ProyectoDTO(long idProyecto, String nombreProy, int fechaProy, String descripcion, String urlGithub,
            String urlPropia, String tecnologia, Persona perso) {
        this.idProyecto = idProyecto;
        this.nombreProy = nombreProy;
        this.fechaProy = fechaProy;
        this.descripcion = descripcion;
        this.urlGithub = urlGithub;
        this.urlPropia = urlPropia;
        this.tecnologia = tecnologia;
        this.perso = perso;
    }

    //Getters y Setters
    public long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProy() {
        return nombreProy;
    }

    public void setNombreProy(String nombreProy) {
        this.nombreProy = nombreProy;
    }

    public int getFechaProy() {
        return fechaProy;
    }

    public void setFechaProy(int fechaProy) {
        this.fechaProy = fechaProy;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlGithub() {
        return urlGithub;
    }

    public void setUrlGithub(String urlGithub) {
        this.urlGithub = urlGithub;
    }

    public String getUrlPropia() {
        return urlPropia;
    }

    public void setUrlPropia(String urlPropia) {
        this.urlPropia = urlPropia;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
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
        return "ProyectoDTO [descripcion=" + descripcion + ", fechaProy=" + fechaProy + ", idProyecto=" + idProyecto
                + ", nombreProy=" + nombreProy + ", perso=" + perso + ", tecnologia=" + tecnologia + ", urlGithub="
                + urlGithub + ", urlPropia=" + urlPropia + "]";
    }
    
}
