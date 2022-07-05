package com.quipildor.portfolio.dto;

import java.util.Date;

import com.quipildor.portfolio.model.Persona;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExpLabDTO {

    private long idExp;
    
    private String nombreEmp;
    
    private int fechaIng;
    
    private int fechaSalida;

    private String descripcion;
    
    private String urlLogo;
    
    // Relaciones
    private Persona perso;

    //Constructores
    /* public ExpLabDTO(long idExp, String nombreEmp, int fechaIng, int fechaSalida, Persona perso) {
        this.idExp = idExp;
        this.nombreEmp = nombreEmp;
        this.fechaIng = fechaIng;
        this.fechaSalida = fechaSalida;
        this.perso = perso;
    } */
    
    public ExpLabDTO(long idExp, String nombreEmp, int fechaIng, int fechaSalida, String descripcion, String urlLogo,
            Persona perso) {
        this.idExp = idExp;
        this.nombreEmp = nombreEmp;
        this.fechaIng = fechaIng;
        this.fechaSalida = fechaSalida;
        this.descripcion = descripcion;
        this.urlLogo = urlLogo;
        this.perso = perso;
    }


    //Getters y Setters
    public long getIdExp() {
        return idExp;
    }

    public void setIdExp(long idExp) {
        this.idExp = idExp;
    }

    public String getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    public int getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(int fechaIng) {
        this.fechaIng = fechaIng;
    }

    public int getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(int fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    //Método ToString
    @Override
    public String toString() {
        return "ExpLabDTO [descripcion=" + descripcion + ", fechaIng=" + fechaIng + ", fechaSalida=" + fechaSalida
                + ", idExp=" + idExp + ", nombreEmp=" + nombreEmp + ", perso=" + perso + ", urlLogo=" + urlLogo + "]";
    }
   
    /* @Override
    public String toString() {
        return "ExpLabDTO [fechaIng=" + fechaIng + ", fechaSalida=" + fechaSalida + ", idExp=" + idExp + ", nombreEmp="
                + nombreEmp + ", perso=" + perso.getId() + "]";
    }
     */
    
}
