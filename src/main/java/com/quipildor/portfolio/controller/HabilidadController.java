package com.quipildor.portfolio.controller;

import java.util.List;

import com.quipildor.portfolio.dto.HabilidadDTO;
import com.quipildor.portfolio.dto.Mensaje;
import com.quipildor.portfolio.interfaz.IHabilidadService;
import com.quipildor.portfolio.model.Habilidad;
//import com.quipildor.portfolio.service.ImpHabilidadService;

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
@RequestMapping("/habilidad")
public class HabilidadController {

    @Autowired IHabilidadService ihabilidadServ;

    @GetMapping("/invitado")
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

    @PostMapping ("/crear")
    public ResponseEntity<?> altaHabilidad(@RequestBody HabilidadDTO habilidadDto){
        Habilidad habilidad = new Habilidad(habilidadDto.getIdHabilidad(), habilidadDto.getTecnologia(), habilidadDto.getPorcentaje(),
                                            habilidadDto.getPosicion(), habilidadDto.getPersona_id());
        ihabilidadServ.crearHabilidad(habilidad);
        return new ResponseEntity<Mensaje>(new Mensaje("La habilidad fue creada."), HttpStatus.OK);
    }

    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<?> borrarHabilidad(@PathVariable Long id){
        if(!ihabilidadServ.existeHabilidad(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("El Id No Existe"), HttpStatus.NOT_FOUND);
        }
        ihabilidadServ.borrarHabilidad(id);
        return new ResponseEntity<Mensaje>(new Mensaje("La habilidad fue borrada."), HttpStatus.OK);
    }

    @PutMapping ("/editar/{id}")
    public ResponseEntity<?> modificarHabilidad(@PathVariable Long id, @RequestBody HabilidadDTO habilidadDto){
        if(!ihabilidadServ.existeHabilidad(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("El Id No Existe"), HttpStatus.NOT_FOUND);
        }
        Habilidad habilidad = ihabilidadServ.buscarHabilidadId(id);

        habilidad.setIdHabilidad(habilidadDto.getIdHabilidad());
        habilidad.setTecnologia(habilidadDto.getTecnologia());
        habilidad.setPorcentaje(habilidadDto.getPorcentaje());
        habilidad.setPosicion(habilidadDto.getPosicion());
        habilidad.setPersona_id(habilidadDto.getPersona_id());

        ihabilidadServ.crearHabilidad(habilidad);

        return new ResponseEntity<Mensaje>(new Mensaje("Habilidad actualizada."), HttpStatus.OK);
    }
    
}
