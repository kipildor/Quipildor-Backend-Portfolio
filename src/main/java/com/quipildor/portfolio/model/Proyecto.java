package com.quipildor.portfolio.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProyecto;
    
    @Column(nullable = false)
    private String nombreProy;
    
    @Column(nullable = true)
    private int fechaProy;
    
    private String descripcion;
    
    private String urlGithub;

    private String urlPropia;

    // Relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Persona perso;
    
    @OneToMany(mappedBy = "proy", cascade = CascadeType.ALL)
    private List<ImgProy> listaImagenes;
    
    
    // Constructores
    public Proyecto() {
    }

/*
    public Proyecto(long idProyecto, String nombreProy, Date fechaProy, String descripcion, String urlGithub,
            String urlPropia) {
        this.idProyecto = idProyecto;
        this.nombreProy = nombreProy;
        this.fechaProy = fechaProy;
        this.descripcion = descripcion;
        this.urlGithub = urlGithub;
        this.urlPropia = urlPropia;
    }
*/
    public Proyecto(long idProyecto, String nombreProy, int fechaProy, String descripcion, String urlGithub,
            String urlPropia, Persona perso) {
        this.idProyecto = idProyecto;
        this.nombreProy = nombreProy;
        this.fechaProy = fechaProy;
        this.descripcion = descripcion;
        this.urlGithub = urlGithub;
        this.urlPropia = urlPropia;
        this.perso = perso;
    }

    // Getters y Setters
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

    public Persona getPerso() {
        return perso;
    }

    public void setPerso(Persona perso) {
        this.perso = perso;
    }

    //Método ToString
    @Override
    public String toString() {
        return "Proyecto [descripcion=" + descripcion + ", fechaProy=" + fechaProy + ", idProyecto=" + idProyecto
                + ", nombreProy=" + nombreProy + ", perso=" + perso + ", urlGithub=" + urlGithub + ", urlPropia="
                + urlPropia + "]";
    }

    
    
}
