package com.quipildor.portfolio.dto;

import java.util.Date;
import java.sql.*;;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonaDTO {

    private long id;
    
    private String nombre;
    
    private String apellido;
    
    private Date fechaNac;
    
    private String email;
    
    private String urlFoto;

    private String urlBanner;
    
    private String password;
    
    private String ubicacion;

    private String titProfesional;

    private String actividadActual;

    //Constructores
    public PersonaDTO(long id, String nombre, String apellido, Date fechaNac, String email, 
                    String urlFoto, String urlBanner, String password, String ubicacion, String titProfesional, 
                    String actividadActual) {
        this.id = id;
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

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
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

    //Método ToString
    @Override
    public String toString() {
        return "PersonaDTO [actividadActual=" + actividadActual + ", apellido=" + apellido + ", email=" + email
                + ", fechaNac=" + fechaNac + ", id=" + id + ", nombre=" + nombre + ", password=" + password
                + ", titProfesional=" + titProfesional + ", ubicacion=" + ubicacion + ", urlBanner=" + urlBanner
                + ", urlFoto=" + urlFoto + "]";
    }

    
    
    
    
}
