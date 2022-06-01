package com.quipildor.portfolio.dto;

import com.quipildor.portfolio.model.Proyecto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ImgProyDTO {

    private long idImgProy;
    
    private String urlImg;

    // Relaciones
    private Proyecto proy;

    //Constructores
    public ImgProyDTO(long idImgProy, String urlImg, Proyecto proy) {
        this.idImgProy = idImgProy;
        this.urlImg = urlImg;
        this.proy = proy;
    }

    //Getters y Setters
    public long getIdImgProy() {
        return idImgProy;
    }

    public void setIdImgProy(long idImgProy) {
        this.idImgProy = idImgProy;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Proyecto getProy() {
        return proy;
    }

    public void setProy(Proyecto proy) {
        this.proy = proy;
    }

    //Método ToString
    @Override
    public String toString() {
        return "ImgProyDTO [idImgProy=" + idImgProy + ", proy=" + proy + ", urlImg=" + urlImg + "]";
    }

    
    
}
