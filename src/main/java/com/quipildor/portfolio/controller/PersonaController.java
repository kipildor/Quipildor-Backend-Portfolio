package com.quipildor.portfolio.controller;

import java.util.Date;
import java.util.List;

import com.quipildor.portfolio.dto.Mensaje;
import com.quipildor.portfolio.dto.PersonaDTO;
import com.quipildor.portfolio.interfaz.IPersonaService;
import com.quipildor.portfolio.model.Persona;

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
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")//resuelve algunos problemas de Heroku
@RequestMapping("/persona/")
public class PersonaController {
    
    @Autowired IPersonaService ipersonaServ;

    @GetMapping ("ver/personas")
    public ResponseEntity<List<Persona>> obtenerPersonas() {
        List<Persona> lista = ipersonaServ.listarPersonas();
        return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
    }

    @GetMapping ("traer/persona/{id}")
    public ResponseEntity<?> buscarPersona(@PathVariable Long id) {
        if(!ipersonaServ.existePersonaId(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("Id No Existe"), HttpStatus.NOT_FOUND);
        }
        Persona perso = ipersonaServ.buscarPersonaPorID(id);
        return new ResponseEntity<Persona>(perso, HttpStatus.OK);
    }

    @PostMapping ("crear/persona")
    public ResponseEntity<?> altaPersona(@RequestBody PersonaDTO persoDto){
        Persona perso = new Persona(persoDto.getId(), persoDto.getNombre(), persoDto.getApellido(), persoDto.getFechaNac(),
                                persoDto.getEmail(), persoDto.getUrlFoto(), persoDto.getUrlBanner(), persoDto.getPassword(),
                                persoDto.getUbicacion(), persoDto.getTitProfesional(), persoDto.getActividadActual());
        ipersonaServ.crearPersona(perso);
        return new ResponseEntity<Mensaje>(new Mensaje("El usuario fue creado."), HttpStatus.OK);
    }

    @DeleteMapping ("borrar/persona/{id}")
    public ResponseEntity<?> borrarPersona(@PathVariable Long id){
        if(!ipersonaServ.existePersonaId(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("El Id No Existe"), HttpStatus.NOT_FOUND);
        }

        ipersonaServ.borrarPersona(id);
        return new ResponseEntity<Mensaje>(new Mensaje("El usuario fue borrado."), HttpStatus.OK);
    }

    @PutMapping ("editar/persona/{id}")
    public ResponseEntity<?> modificarPersona(@PathVariable Long id, @RequestBody PersonaDTO persoDto){
        if(!ipersonaServ.existePersonaId(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("El Id No Existe"), HttpStatus.NOT_FOUND);
        }
        Persona perso = ipersonaServ.buscarPersonaPorID(id);

        perso.setNombre(persoDto.getNombre());
        perso.setApellido(persoDto.getApellido());
        perso.setFechaNac(persoDto.getFechaNac());
        perso.setEmail(persoDto.getEmail());
        perso.setUrlFoto(persoDto.getUrlFoto());
        perso.setUrlBanner(persoDto.getUrlBanner());
        perso.setPassword(persoDto.getPassword());
        perso.setUbicacion(persoDto.getUbicacion());
        perso.setTitProfesional(persoDto.getTitProfesional());
        perso.setActividadActual(persoDto.getActividadActual());

        ipersonaServ.crearPersona(perso);

        return new ResponseEntity<Mensaje>(new Mensaje("Usuario actualizado."), HttpStatus.OK);
    }

    //No modifico el email xq debe ser unico en la BDD y todavia no implemento el comprobarlo antes de cambiarlo
    /*
    @PutMapping ("editar/persona/{id}")
    public Persona modificarPersona(@PathVariable Long id,
                                    @RequestParam("nombre") String newNombre,
                                    @RequestParam("apellido") String newApellido,
                                    @RequestParam("fecha") Date newFecha,
                                    @RequestParam("foto") String newDirFoto,
                                    @RequestParam("banner") String newDirBanner,
                                    @RequestParam("k") String newPassword,
                                    @RequestParam("ubicacion") String newUbicacion,
                                    @RequestParam("titulo") String newTitulo,
                                    @RequestParam("actividad") String newActividad) {
        
        Persona perso = ipersonaServ.buscarPersonaPorID(id);

        perso.setNombre(newNombre);
        perso.setApellido(newApellido);
        perso.setFechaNac(newFecha);
        perso.setUrlFoto(newDirFoto);
        perso.setUrlBanner(newDirBanner);
        perso.setPassword(newPassword);
        perso.setUbicacion(newUbicacion);
        perso.setTitProfesional(newTitulo);
        perso.setActividadActual(newActividad);

        ipersonaServ.actualizarPersona(perso);

        return perso;
    }
    */

}
