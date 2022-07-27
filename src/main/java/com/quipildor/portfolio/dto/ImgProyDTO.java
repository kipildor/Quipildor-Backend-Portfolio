package com.quipildor.portfolio.dto;

import com.quipildor.portfolio.model.Proyecto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ImgProyDTO {

    private long idImgProy;
    
    private long idUrlImg;

    private String urlImg;

    // Relaciones
    private long proyecto_id;

    //Constructores
    public ImgProyDTO(long idImgProy, long idUrlImg, String urlImg, long proyecto_id) {
        this.idImgProy = idImgProy;
        this.idUrlImg = idUrlImg;
        this.urlImg = urlImg;
        this.proyecto_id = proyecto_id;
    }

    //Getters y Setters
    public long getIdImgProy() {
        return idImgProy;
    }

    public void setIdImgProy(long idImgProy) {
        this.idImgProy = idImgProy;
    }

    public long getIdUrlImg() {
        return idUrlImg;
    }

    public void setIdUrlImg(long idUrlImg) {
        this.idUrlImg = idUrlImg;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public long getProyecto_id() {
        return proyecto_id;
    }

    public void setProyecto_id(long proyecto_id) {
        this.proyecto_id = proyecto_id;
    }

    //Método ToString
    @Override
    public String toString() {
        return "ImgProyDTO [idImgProy=" + idImgProy + ", proy=" + proyecto_id + ", idUrlImg=" + idUrlImg + ", urlImg=" + urlImg + "]";
    }

    
    
}
