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
    private long persona_id;

    //Constructores
    public ProyectoDTO(long idProyecto, String nombreProy, int fechaProy, String descripcion, String urlGithub,
            String urlPropia, String tecnologia, long persona_id) {
        this.idProyecto = idProyecto;
        this.nombreProy = nombreProy;
        this.fechaProy = fechaProy;
        this.descripcion = descripcion;
        this.urlGithub = urlGithub;
        this.urlPropia = urlPropia;
        this.tecnologia = tecnologia;
        this.persona_id = persona_id;
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

    public long getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(long persona_id) {
        this.persona_id = persona_id;
    }

    //Método ToString
    @Override
    public String toString() {
        return "ProyectoDTO [descripcion=" + descripcion + ", fechaProy=" + fechaProy + ", idProyecto=" + idProyecto
                + ", nombreProy=" + nombreProy + ", perso=" + persona_id + ", tecnologia=" + tecnologia + ", urlGithub="
                + urlGithub + ", urlPropia=" + urlPropia + "]";
    }
    
}
