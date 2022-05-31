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
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date fechaProy;
    
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


    public Proyecto(long idProyecto, String nombreProy, Date fechaProy, String descripcion, String urlGithub,
            String urlPropia) {
        this.idProyecto = idProyecto;
        this.nombreProy = nombreProy;
        this.fechaProy = fechaProy;
        this.descripcion = descripcion;
        this.urlGithub = urlGithub;
        this.urlPropia = urlPropia;
    }

    
    
}
