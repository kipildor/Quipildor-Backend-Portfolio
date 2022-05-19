package com.quipildor.portfolio.controller;

import java.util.Date;
import java.util.List;

import com.quipildor.portfolio.interfaz.IPersonaService;
import com.quipildor.portfolio.model.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    
    @Autowired IPersonaService ipersonaServ;

    @GetMapping ("personas")
    public List<Persona> obtenerPersonas() {
        return ipersonaServ.listarPersonas();
    }

    @GetMapping ("traer/persona/{id}")
    public Persona traerPersona(@PathVariable Long id) {
        return ipersonaServ.buscarPersonaPorID(id);
    }

    @PostMapping ("crear/persona")
    public String altaPersona(@RequestBody Persona perso){
        ipersonaServ.crearPersona(perso);
        return("El usuario fue creado con exito.");
    }

    @DeleteMapping ("borrar/persona/{id}")
    public String borrarPersona(@PathVariable Long id){
        ipersonaServ.borrarPersona(id);
        return("El usuario fue borrado con exito.");
    }

    //No modifico el email xq debe ser unico en la BDD y todavia no implemento el comprobarlo antes de cambiarlo
    @PutMapping ("editar/persona/{id}")
    public Persona modificarPersona(@PathVariable Long id,
                                    @RequestParam("nom") String newNombre,
                                    @RequestParam("ape") String newApellido,
                                    @RequestParam("fec") Date newFecha,
                                    @RequestParam("foto") String newDirFoto,
                                    @RequestParam("banner") String newDirBanner,
                                    @RequestParam("k") String newPassword,
                                    @RequestParam("lugar") String newUbicacion,
                                    @RequestParam("tit") String newTitulo,
                                    @RequestParam("activ") String newActividad) {
        
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

}
