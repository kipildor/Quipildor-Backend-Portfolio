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
    
    @Column(nullable = false)
    private String urlImg;

    // Relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proyecto_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Proyecto proy;
    
    // Constructores
    public ImgProy() {
    }

    public ImgProy(long idImgProy, String urlImg) {
        this.idImgProy = idImgProy;
        this.urlImg = urlImg;
    }
    
    
}
