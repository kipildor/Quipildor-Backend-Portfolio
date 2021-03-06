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

    @Column(nullable = true)
    private String tecnologia;

    // Relaciones
    /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    @JsonProperty(access = Access.WRITE_ONLY) */
    private long persona_id;
    
    /* @OneToMany(mappedBy = "proy", cascade = CascadeType.ALL)
    private List<ImgProy> listaImagenes; */
    
    
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

    //M??todo ToString
    @Override
    public String toString() {
        return "Proyecto [descripcion=" + descripcion + ", fechaProy=" + fechaProy + ", idProyecto=" + idProyecto
                /* + ", listaImagenes=" + listaImagenes */ + ", nombreProy=" + nombreProy + ", perso=" + persona_id
                + ", tecnologia=" + tecnologia + ", urlGithub=" + urlGithub + ", urlPropia=" + urlPropia + "]";
    }

        
}
