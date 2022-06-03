package com.quipildor.portfolio.controller;

import java.util.List;

import com.quipildor.portfolio.dto.Mensaje;
import com.quipildor.portfolio.interfaz.IHabilidadService;
import com.quipildor.portfolio.model.Habilidad;
//import com.quipildor.portfolio.service.ImpHabilidadService;

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
@RequestMapping("/habilidad")
public class HabilidadController {

    @Autowired IHabilidadService ihabilidadServ;

    @GetMapping("")
    public ResponseEntity<List<Habilidad>> obtenerHabilidades() {
        List<Habilidad> listaHabilidades = ihabilidadServ.listarHabilidades();
        return new ResponseEntity<List<Habilidad>>(listaHabilidades, HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> buscarHabilidad(@PathVariable Long id) {
        if(!ihabilidadServ.existeHabilidad(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("Id No Existe"), HttpStatus.NOT_FOUND);
        }
        Habilidad habilid = ihabilidadServ.buscarHabilidadId(id);
        return new ResponseEntity<Habilidad>(habilid, HttpStatus.OK);
        
    }
    
}