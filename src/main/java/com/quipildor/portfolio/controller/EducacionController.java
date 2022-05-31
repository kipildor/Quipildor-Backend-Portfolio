package com.quipildor.portfolio.controller;

import java.util.List;

import com.quipildor.portfolio.dto.Mensaje;
import com.quipildor.portfolio.interfaz.IEducacionService;
import com.quipildor.portfolio.model.Educacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/educ")
public class EducacionController {

    @Autowired IEducacionService ieducServ;

    @GetMapping ("")
    public ResponseEntity<List<Educacion>> listarEduc() {

        List<Educacion> listaEduc = ieducServ.listarEducacion();
        return new ResponseEntity<List<Educacion>>(listaEduc, HttpStatus.OK);
        
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> buscarEduc(@PathVariable Long id) {
        if(!ieducServ.existeEducacion(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("Id No Existe"), HttpStatus.NOT_FOUND);
        }
        Educacion educ = ieducServ.buscarEducacion(id);
        return new ResponseEntity<Educacion>(educ, HttpStatus.OK);
        
    }
    
}
