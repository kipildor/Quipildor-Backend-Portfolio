package com.quipildor.portfolio.dto;

import java.util.Date;

import com.quipildor.portfolio.model.Persona;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExpLabDTO {

    private long idExp;
    
    private String nombreEmp;
    
    private Date fechaIng;
    
    private Date fechaSalida;
    
    // Relaciones
    private Persona perso;

    //Constructores
    public ExpLabDTO(long idExp, String nombreEmp, Date fechaIng, Date fechaSalida, Persona perso) {
        this.idExp = idExp;
        this.nombreEmp = nombreEmp;
        this.fechaIng = fechaIng;
        this.fechaSalida = fechaSalida;
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

    public Date getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Date fechaIng) {
        this.fechaIng = fechaIng;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
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
        return "ExpLabDTO [fechaIng=" + fechaIng + ", fechaSalida=" + fechaSalida + ", idExp=" + idExp + ", nombreEmp="
                + nombreEmp + ", perso=" + perso.getId() + "]";
    }

    
    
}
