package com.quipildor.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EstadoDTO {

    private int idEstado;
    
    private String descripcion;

    //Constructores
    public EstadoDTO(int idEstado, String descripcion) {
        this.idEstado = idEstado;
        this.descripcion = descripcion;
    }

    //Getters y Setters
    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //Método ToString
    @Override
    public String toString() {
        return "EstadoDTO [descripcion=" + descripcion + ", idEstado=" + idEstado + "]";
    }

    
    
}
