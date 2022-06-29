package com.quipildor.portfolio.controller;

import java.util.List;

import com.quipildor.portfolio.dto.Mensaje;
import com.quipildor.portfolio.interfaz.IAcercaDeMiService;
import com.quipildor.portfolio.model.AcercaDeMi;

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
@RequestMapping("/acerca")
public class AcercaDeController {
    
    @Autowired IAcercaDeMiService iacercaServ;

    @GetMapping ("/invitado")
    public ResponseEntity<List<AcercaDeMi>> listarAcerca() {

        List<AcercaDeMi> listaAcerca = iacercaServ.listarParrafos();
        return new ResponseEntity<List<AcercaDeMi>>(listaAcerca, HttpStatus.OK);
        
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> buscarParrafo(@PathVariable Long id) {
        if(!iacercaServ.existeParrafoId(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("Id No Existe"), HttpStatus.NOT_FOUND);
        }
        AcercaDeMi parrafo = iacercaServ.buscarParrafo(id);
        return new ResponseEntity<AcercaDeMi>(parrafo, HttpStatus.OK);
        
    }
}
