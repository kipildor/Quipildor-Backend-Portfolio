package com.quipildor.portfolio.controller;

import java.util.List;

import com.quipildor.portfolio.dto.EstadoDTO;
import com.quipildor.portfolio.dto.Mensaje;
import com.quipildor.portfolio.interfaz.IEstadoService;
import com.quipildor.portfolio.model.Estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
@CrossOrigin(origins = "*")
public class EstadoController {

    @Autowired IEstadoService iestadoServ;

    @GetMapping ("/invitado")
    public ResponseEntity<List<Estado>> listarEst() {

        List<Estado> listaEstados = iestadoServ.listarEstados();
        return new ResponseEntity<List<Estado>>(listaEstados, HttpStatus.OK);
        
    }

    @GetMapping ("/invitado/{id}")
    public ResponseEntity<?> buscarEst(@PathVariable int id) {
        if(!iestadoServ.existeEstado(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("Id No Existe"), HttpStatus.NOT_FOUND);
        }
        Estado estado = iestadoServ.buscarEstado(id);
        return new ResponseEntity<Estado>(estado, HttpStatus.OK);
        
    }
    
    @PostMapping ("/invitado/crear")
    public ResponseEntity<?> altaEstado(@RequestBody EstadoDTO estadoDto){
        Estado estado = new Estado(estadoDto.getIdEstado(), estadoDto.getDescripcion());
        iestadoServ.crearEstado(estado);
        return new ResponseEntity<Mensaje>(new Mensaje("El estado fue agregado."), HttpStatus.OK);
    }
}
