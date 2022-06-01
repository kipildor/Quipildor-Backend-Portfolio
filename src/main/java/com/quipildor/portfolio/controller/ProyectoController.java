package com.quipildor.portfolio.controller;

import java.util.List;

import com.quipildor.portfolio.dto.Mensaje;
import com.quipildor.portfolio.interfaz.IProyectoService;
import com.quipildor.portfolio.model.Proyecto;

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
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired IProyectoService iproyServ;

    @GetMapping ("")
    public ResponseEntity<List<Proyecto>> listarProy() {

        List<Proyecto> listaProyectos = iproyServ.listarProyectos();
        return new ResponseEntity<List<Proyecto>>(listaProyectos, HttpStatus.OK);
        
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> buscarProyecto(@PathVariable Long id) {
        if(!iproyServ.existeProyecto(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("Id No Existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = iproyServ.buscarProyecto(id);
        return new ResponseEntity<Proyecto>(proyecto, HttpStatus.OK);
        
    }
    
}
