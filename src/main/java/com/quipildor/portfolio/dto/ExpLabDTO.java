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

    private long idUrlLogo;
    
    private String urlLogo;
    
    // Relaciones
    private long persona_id;

    //Constructores
    /* public ExpLabDTO(long idExp, String nombreEmp, int fechaIng, int fechaSalida, Persona perso) {
        this.idExp = idExp;
        this.nombreEmp = nombreEmp;
        this.fechaIng = fechaIng;
        this.fechaSalida = fechaSalida;
        this.perso = perso;
    } */
    
    public ExpLabDTO(long idExp, String nombreEmp, int fechaIng, int fechaSalida, String descripcion, long idUrlLogo,
                    String urlLogo, long persona_id) {
        this.idExp = idExp;
        this.nombreEmp = nombreEmp;
        this.fechaIng = fechaIng;
        this.fechaSalida = fechaSalida;
        this.descripcion = descripcion;
        this.idUrlLogo = idUrlLogo;
        this.urlLogo = urlLogo;
        this.persona_id = persona_id;
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

    public long getIdUrlLogo() {
        return idUrlLogo;
    }

    public void setIdUrlLogo(long idUrlLogo) {
        this.idUrlLogo = idUrlLogo;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
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
        return "ExpLabDTO [descripcion=" + descripcion + ", fechaIng=" + fechaIng + ", fechaSalida=" + fechaSalida
                + ", idExp=" + idExp + ", nombreEmp=" + nombreEmp + ", perso=" + persona_id + ", idUrlLogo=" + idUrlLogo
                + ", urlLogo=" + urlLogo + "]";
    }
   
    /* @Override
    public String toString() {
        return "ExpLabDTO [fechaIng=" + fechaIng + ", fechaSalida=" + fechaSalida + ", idExp=" + idExp + ", nombreEmp="
                + nombreEmp + ", perso=" + perso.getId() + "]";
    }
     */
    
}
