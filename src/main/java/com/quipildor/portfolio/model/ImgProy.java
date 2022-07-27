package com.quipildor.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class ImgProy {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idImgProy;
    
    private long idUrlImg;

    @Column(nullable = false)
    private String urlImg;

    // Relaciones
    /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proyecto_id")
    @JsonProperty(access = Access.WRITE_ONLY) */
    private long proyecto_id;
    
    // Constructores
    public ImgProy() {
    }

    public ImgProy(long idImgProy, long idUrlImg, String urlImg, long proyecto_id) {
        this.idImgProy = idImgProy;
        this.idUrlImg = idUrlImg;
        this.urlImg = urlImg;
        this.proyecto_id = proyecto_id;
    }
/*
    public ImgProy(long idImgProy, String urlImg) {
        this.idImgProy = idImgProy;
        this.urlImg = urlImg;
    }
*/

    // Getters y Setters
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
        return "ImgProy [idImgProy=" + idImgProy + ", proy=" + proyecto_id + ", idUrlImg=" + idUrlImg + ", urlImg=" + urlImg + "]";
    }  

    
}
