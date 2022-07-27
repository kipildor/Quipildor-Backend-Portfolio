package com.quipildor.portfolio.controller;

import java.util.List;

import com.quipildor.portfolio.dto.AcercaDeDTO;
import com.quipildor.portfolio.dto.Mensaje;
import com.quipildor.portfolio.interfaz.IAcercaDeMiService;
import com.quipildor.portfolio.model.AcercaDeMi;

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

    @PostMapping ("/crear")
    public ResponseEntity<?> altaParrafo(@RequestBody AcercaDeDTO acercaDto){
        AcercaDeMi acerca = new AcercaDeMi(acercaDto.getIdParrafo(), acercaDto.getParrafo(), acercaDto.getPosicion(),
                                acercaDto.getPersona_id());
        iacercaServ.crearParrafo(acerca);
        return new ResponseEntity<Mensaje>(new Mensaje("El párrafo fue creado."), HttpStatus.OK);
    }

    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<?> borrarParrafo(@PathVariable Long id){
        if(!iacercaServ.existeParrafoId(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("El Id No Existe"), HttpStatus.NOT_FOUND);
        }

        iacercaServ.borrarParrafo(id);
        return new ResponseEntity<Mensaje>(new Mensaje("El párrafo fue borrado."), HttpStatus.OK);
    }

    @PutMapping ("/editar/{id}")
    public ResponseEntity<?> modificarParrafo(@PathVariable Long id, @RequestBody AcercaDeDTO acercaDto){
        if(!iacercaServ.existeParrafoId(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("El Id No Existe"), HttpStatus.NOT_FOUND);
        }
        AcercaDeMi acerca = iacercaServ.buscarParrafo(id);

        acerca.setIdParrafo(acercaDto.getIdParrafo());
        acerca.setParrafo(acercaDto.getParrafo());
        acerca.setPosicion(acercaDto.getPosicion());
        acerca.setPersona_id(acercaDto.getPersona_id());
        //comenté la linea porque al actualizar en el front el id_persona me lo dejaba como NULL
        iacercaServ.crearParrafo(acerca);

        return new ResponseEntity<Mensaje>(new Mensaje("Párrafo actualizado."), HttpStatus.OK);
    }

} 
