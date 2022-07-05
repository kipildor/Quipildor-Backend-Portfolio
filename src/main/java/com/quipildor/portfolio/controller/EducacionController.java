package com.quipildor.portfolio.controller;

import java.util.List;

import com.quipildor.portfolio.dto.EducacionDTO;
import com.quipildor.portfolio.dto.Mensaje;
import com.quipildor.portfolio.interfaz.IEducacionService;
import com.quipildor.portfolio.model.Educacion;

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
@RequestMapping("/educ")
public class EducacionController {

    @Autowired IEducacionService ieducServ;

    @GetMapping ("/invitado")
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

    @PostMapping ("/crear")
    public ResponseEntity<?> altaEducacion(@RequestBody EducacionDTO educacionDto){
        Educacion educacion = new Educacion(educacionDto.getIdEduc(), educacionDto.getNombreInstit(), educacionDto.getFechaInicio(),
                                            educacionDto.getFechaFin(), educacionDto.getTitulo(), educacionDto.getUrlLogo(),
                                            educacionDto.getPerso(), educacionDto.getEstado());
        ieducServ.crearEducacion(educacion);
        return new ResponseEntity<Mensaje>(new Mensaje("La educación fue agregada."), HttpStatus.OK);
    }

    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<?> borrarEducacion(@PathVariable Long id){
        if(!ieducServ.existeEducacion(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("El Id No Existe"), HttpStatus.NOT_FOUND);
        }
        ieducServ.borrarEducacion(id);
        return new ResponseEntity<Mensaje>(new Mensaje("La educación fue borrada."), HttpStatus.OK);
    }

    @PutMapping ("/editar/{id}")
    public ResponseEntity<?> modificarEducacion(@PathVariable Long id, @RequestBody EducacionDTO educacionDto){
        if(!ieducServ.existeEducacion(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("El Id No Existe"), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = ieducServ.buscarEducacion(id);

        educacion.setIdEduc(educacionDto.getIdEduc());
        educacion.setNombreInstit(educacionDto.getNombreInstit());
        educacion.setFechaInicio(educacionDto.getFechaInicio());
        educacion.setFechaFin(educacionDto.getFechaFin());
        educacion.setTitulo(educacionDto.getTitulo());
        educacion.setUrlLogo(educacionDto.getUrlLogo());
        educacion.setEstado(educacionDto.getEstado());
        educacion.setPerso(educacionDto.getPerso());
        
        ieducServ.crearEducacion(educacion);

        return new ResponseEntity<Mensaje>(new Mensaje("Educación actualizada."), HttpStatus.OK);
    }
    
}
