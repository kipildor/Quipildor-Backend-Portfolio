package com.quipildor.portfolio.controller;

import java.util.List;

import com.quipildor.portfolio.dto.Mensaje;
import com.quipildor.portfolio.interfaz.IExpLabService;
import com.quipildor.portfolio.model.ExpLab;

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
@RequestMapping("/exp")
public class ExpLabController {

    @Autowired IExpLabService iexp;

    @GetMapping("")
    public ResponseEntity<List<ExpLab>> listarExperiencias() {

        List<ExpLab> listaExp = iexp.listarExpLab();
        return new ResponseEntity<List<ExpLab>>(listaExp, HttpStatus.OK);
        
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> buscarExpLab(@PathVariable Long id) {
        if(!iexp.existeExpLab(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("Id No Existe"), HttpStatus.NOT_FOUND);
        }
        ExpLab experiencia = iexp.buscarExpLab(id);
        return new ResponseEntity<ExpLab>(experiencia, HttpStatus.OK);
        
    }

    
}
