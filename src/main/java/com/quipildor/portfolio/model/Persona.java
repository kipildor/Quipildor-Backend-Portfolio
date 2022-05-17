package com.quipildor.portfolio.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /*
    @Column(nullable=false)
    private long doc;
    */
    @Column(nullable=false)
    private String nombre;
    
    @Column(nullable=false)
    private String apellido;
    
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    private String urlFoto;
    private String urlBanner;
    
    @Column(nullable = false)
    private String password;
    
    private String ubicacion;
    private String titProfesional;
    private String actividadActual;

    // Relaciones
    @OneToMany(mappedBy = "perso", cascade = CascadeType.ALL)
    private List<AcercaDeMi> listaAcercaDeMi;

    @OneToMany(mappedBy = "perso", cascade = CascadeType.ALL)
    private List<ExpLab> listaExpLab;

    @OneToMany(mappedBy = "perso", cascade = CascadeType.ALL)
    private List<Educacion> listaEducacion;

    @OneToMany(mappedBy = "perso", cascade = CascadeType.ALL)
    private List<Proyecto> listaProyectos;

    @OneToMany(mappedBy = "perso", cascade = CascadeType.ALL)
    private List<Habilidad> listaHabilidades;
    
    // Constructores
    public Persona() {
    }

    public Persona(long id, /*long doc,*/ String nombre, String apellido, Date fechaNac, String email, String urlFoto, String urlBanner, String password, String ubicacion, String titProfesional, String actividadActual) {
        this.id = id;
        //this.doc = doc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.email = email;
        this.urlFoto = urlFoto;
        this.urlBanner = urlBanner;
        this.password = password;
        this.ubicacion = ubicacion;
        this.titProfesional = titProfesional;
        this.actividadActual = actividadActual;
    }
    
        
}
