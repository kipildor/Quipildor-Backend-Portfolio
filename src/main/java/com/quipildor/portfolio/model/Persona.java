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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /*
    @Column(nullable=false)
    private long doc;
    */
    //@Column(nullable=false)
    private String nombre;
    
    //@Column(nullable=false)
    private String apellido;
    
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    
    //@Column(nullable = false, unique = true)
    @Column(unique = true)
    private String email;
    
    private long idUrlFoto;
    private String urlFoto;

    private long idUrlBanner;
    private String urlBanner;
    
    //@Column(nullable = false)
    private String password;
    
    private String ubicacion;
    private String titProfesional;
    private String actividadActual;

    // Relaciones
    /* @OneToMany(mappedBy = "perso")
    private List<AcercaDeMi> listaAcercaDeMi;

    @OneToMany(mappedBy = "perso")
    private List<ExpLab> listaExpLab;

    @OneToMany(mappedBy = "perso")
    private List<Educacion> listaEducacion;

    @OneToMany(mappedBy = "perso")
    private List<Proyecto> listaProyectos;

    @OneToMany(mappedBy = "perso")
    private List<Habilidad> listaHabilidades; */
    
    // Constructores
    public Persona() {
    }

    public Persona(long id, String nombre, String apellido, Date fechaNac, String email, 
                    long idUrlFoto, String urlFoto, long idUrlBanner, String urlBanner, String password, 
                    String ubicacion, String titProfesional, String actividadActual) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.email = email;
        this.idUrlFoto = idUrlFoto;
        this.urlFoto = urlFoto;
        this.idUrlBanner = idUrlBanner;
        this.urlBanner = urlBanner;
        this.password = password;
        this.ubicacion = ubicacion;
        this.titProfesional = titProfesional;
        this.actividadActual = actividadActual;
    }

    //Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getIdUrlFoto() {
        return idUrlFoto;
    }

    public void setIdUrlFoto(long idUrlFoto) {
        this.idUrlFoto = idUrlFoto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public long getIdUrlBanner() {
        return idUrlBanner;
    }

    public void setIdUrlBanner(long idUrlBanner) {
        this.idUrlBanner = idUrlBanner;
    }

    public String getUrlBanner() {
        return urlBanner;
    }

    public void setUrlBanner(String urlBanner) {
        this.urlBanner = urlBanner;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTitProfesional() {
        return titProfesional;
    }

    public void setTitProfesional(String titProfesional) {
        this.titProfesional = titProfesional;
    }

    public String getActividadActual() {
        return actividadActual;
    }

    public void setActividadActual(String actividadActual) {
        this.actividadActual = actividadActual;
    }
/*
    public List<AcercaDeMi> getListaAcercaDeMi() {
        return listaAcercaDeMi;
    }

    public void setListaAcercaDeMi(List<AcercaDeMi> listaAcercaDeMi) {
        this.listaAcercaDeMi = listaAcercaDeMi;
        
        for(AcercaDeMi parrafo : listaAcercaDeMi){
            parrafo.setPerso(this);
        }
        
    }
*/

    //M??todo ToString
    @Override
    public String toString() {
        return "Persona [actividadActual=" + actividadActual + ", apellido=" + apellido + ", email=" + email
                + ", fechaNac=" + fechaNac + ", id=" + id + /* ", listaAcercaDeMi=" + listaAcercaDeMi + ", listaEducacion="
                + listaEducacion + ", listaExpLab=" + listaExpLab + ", listaHabilidades=" + listaHabilidades
                + ", listaProyectos=" + listaProyectos +  */", nombre=" + nombre + ", password=" + password
                + ", titProfesional=" + titProfesional + ", ubicacion=" + ubicacion + ", idUrlBanner=" + idUrlBanner
                + ", urlBanner=" + urlBanner + ", idUrlFoto=" + idUrlFoto + ", urlFoto=" + urlFoto + "]";
    }
    
        
}
