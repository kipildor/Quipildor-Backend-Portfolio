package com.quipildor.portfolio.controller;

import java.util.List;

import com.quipildor.portfolio.dto.Mensaje;
import com.quipildor.portfolio.dto.ProyectoDTO;
import com.quipildor.portfolio.interfaz.IProyectoService;
import com.quipildor.portfolio.model.Proyecto;

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
@CrossOrigin(origins = "*")//resuelve algunos problemas de Heroku
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired IProyectoService iproyServ;

    @GetMapping ("/invitado")
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

    @PostMapping ("/crear")
    public ResponseEntity<?> altaProyecto(@RequestBody ProyectoDTO proyectoDto){
        Proyecto proyecto = new Proyecto(proyectoDto.getIdProyecto(), proyectoDto.getNombreProy(), proyectoDto.getFechaProy(),
                                        proyectoDto.getDescripcion(), proyectoDto.getUrlGithub(), proyectoDto.getUrlPropia(),
                                        proyectoDto.getTecnologia(), proyectoDto.getPerso());
        iproyServ.crearProyecto(proyecto);
        return new ResponseEntity<Mensaje>(new Mensaje("El proyecto fue creado."), HttpStatus.OK);
    }

    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<?> borrarProyecto(@PathVariable Long id){
        if(!iproyServ.existeProyecto(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("El Id No Existe"), HttpStatus.NOT_FOUND);
        }
        iproyServ.borrarProyecto(id);
        return new ResponseEntity<Mensaje>(new Mensaje("El proyecto fue borrado."), HttpStatus.OK);
    }

    @PutMapping ("/editar/{id}")
    public ResponseEntity<?> modificarProyecto(@PathVariable Long id, @RequestBody ProyectoDTO proyectoDto){
        if(!iproyServ.existeProyecto(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("El Id No Existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = iproyServ.buscarProyecto(id);

        proyecto.setIdProyecto(proyectoDto.getIdProyecto());
        proyecto.setNombreProy(proyectoDto.getNombreProy());
        proyecto.setFechaProy(proyectoDto.getFechaProy());
        proyecto.setDescripcion(proyectoDto.getDescripcion());
        proyecto.setUrlGithub(proyectoDto.getUrlGithub());
        proyecto.setUrlPropia(proyectoDto.getUrlPropia());
        proyecto.setTecnologia(proyectoDto.getTecnologia());
        proyecto.setPerso(proyectoDto.getPerso());

        iproyServ.crearProyecto(proyecto);

        return new ResponseEntity<Mensaje>(new Mensaje("Proyecto actualizado."), HttpStatus.OK);
    }
    
}
