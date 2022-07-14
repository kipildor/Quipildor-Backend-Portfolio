package com.quipildor.portfolio.controller;

import java.util.List;

import com.quipildor.portfolio.dto.ExpLabDTO;
import com.quipildor.portfolio.dto.Mensaje;
import com.quipildor.portfolio.interfaz.IExpLabService;
import com.quipildor.portfolio.model.ExpLab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/exp")
public class ExpLabController {

    @Autowired IExpLabService iexpServ;

    @GetMapping("/invitado")
    public ResponseEntity<List<ExpLab>> listarExperiencias() {

        List<ExpLab> listaExp = iexpServ.listarExpLab();
        return new ResponseEntity<List<ExpLab>>(listaExp, HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> buscarExpLab(@PathVariable Long id) {
        if(!iexpServ.existeExpLab(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("Id No Existe"), HttpStatus.NOT_FOUND);
        }
        ExpLab experiencia = iexpServ.buscarExpLab(id);
        return new ResponseEntity<ExpLab>(experiencia, HttpStatus.OK);
    }

    @PostMapping ("/crear")
    public ResponseEntity<?> altaExperiencia(@RequestBody ExpLabDTO expLabDto){
        ExpLab experiencia = new ExpLab(expLabDto.getIdExp(), expLabDto.getNombreEmp(), expLabDto.getFechaIng(),
                                expLabDto.getFechaSalida(), expLabDto.getDescripcion(), expLabDto.getIdUrlLogo(),
                                expLabDto.getUrlLogo(), expLabDto.getPerso());
        iexpServ.crearExpLab(experiencia);
        return new ResponseEntity<Mensaje>(new Mensaje("La experiencia fue agregada."), HttpStatus.OK);
    }

    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<?> borrarExperiencia(@PathVariable Long id){
        if(!iexpServ.existeExpLab(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("El Id No Existe"), HttpStatus.NOT_FOUND);
        }
        iexpServ.borrarExpLab(id);
        return new ResponseEntity<Mensaje>(new Mensaje("La experiencia fue borrada."), HttpStatus.OK);
    }

    @PutMapping ("/editar/{id}")
    public ResponseEntity<?> modificarExperiencia(@PathVariable Long id, @RequestBody ExpLabDTO expLabDto){
        if(!iexpServ.existeExpLab(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("El Id No Existe"), HttpStatus.NOT_FOUND);
        }
        ExpLab expLab = iexpServ.buscarExpLab(id);

        expLab.setIdExp(expLabDto.getIdExp());
        expLab.setNombreEmp(expLabDto.getNombreEmp());
        expLab.setFechaIng(expLabDto.getFechaIng());
        expLab.setFechaSalida(expLabDto.getFechaSalida());
        expLab.setDescripcion(expLabDto.getDescripcion());
        expLab.setIdUrlLogo(expLabDto.getIdUrlLogo());
        expLab.setUrlLogo(expLabDto.getUrlLogo());
        expLab.setPerso(expLabDto.getPerso());

        iexpServ.crearExpLab(expLab);

        return new ResponseEntity<Mensaje>(new Mensaje("Experiencia actualizada."), HttpStatus.OK);
    }

    
}
