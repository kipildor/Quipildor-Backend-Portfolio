package com.quipildor.portfolio.controller;

import java.util.List;

import com.quipildor.portfolio.interfaz.IAcercaDeMiService;
import com.quipildor.portfolio.model.AcercaDeMi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")//resuelve algunos problemas de Heroku
@RequestMapping("")
public class AcercaDeController {
    
    @Autowired IAcercaDeMiService iacercaServ;

    @GetMapping ("/acerca")
    public ResponseEntity<List<AcercaDeMi>> listarAcerca() {

        List<AcercaDeMi> listaAcerca = iacercaServ.listarParrafos();
        return new ResponseEntity<List<AcercaDeMi>>(listaAcerca, HttpStatus.OK);
        
    }
}
