package com.quipildor.portfolio.controller;

import java.util.List;

import com.quipildor.portfolio.dto.Mensaje;
import com.quipildor.portfolio.interfaz.IImgProyService;
import com.quipildor.portfolio.model.ImgProy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")//resuelve algunos problemas de Heroku
@RequestMapping("/imagen")
public class ImgProyController {

    @Autowired IImgProyService iimgServ;

    @GetMapping ("")
    public ResponseEntity<List<ImgProy>> listarImagenesProyecto() {

        List<ImgProy> listaImagenes = iimgServ.listarImagenesProy();
        return new ResponseEntity<List<ImgProy>>(listaImagenes, HttpStatus.OK);
        
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> buscarImagen(@PathVariable Long id) {
        if(!iimgServ.existeImagenProy(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("Id No Existe"), HttpStatus.NOT_FOUND);
        }
        ImgProy imagen = iimgServ.buscarImagenProy(id);
        return new ResponseEntity<ImgProy>(imagen, HttpStatus.OK);
        
    }
    
}
