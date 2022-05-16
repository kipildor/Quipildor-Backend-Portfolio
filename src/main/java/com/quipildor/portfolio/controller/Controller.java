package com.quipildor.portfolio.controller;

import com.quipildor.portfolio.model.Persona;
import com.quipildor.portfolio.service.IPersonaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
    
    @Autowired
    private IPersonaService persoServ;
    
    @PostMapping ("/new/persona")
    public void agregarPersona (@RequestBody Persona pers) {
        persoServ.crearPersona(pers);
    }
    
    @GetMapping ("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas() {
        return persoServ.verPersonas();
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarPersona (@PathVariable Long id) {
        persoServ.borrarPersona(id);
    }
    
    @PutMapping ("/actualizar/persona")
    public void actualizarPersona (@RequestBody Persona pers) {
        persoServ.actualizarPersona(pers);
    }
    
    
/*    
    List<Persona> listaPersonas = new ArrayList();
    
    @GetMapping ("/hola/{nombre}/{apellido}/{edad}")
    public String decirHola(@PathVariable String nombre,
                            @PathVariable String apellido,
                            @PathVariable int edad){
        return "Hola " + nombre + " " + apellido + " de " + edad + " años.";
    }//Ejemplo:    localhost:8080/hola/Leandro/Quipildor/41
    
    
    
    @GetMapping ("/chau")
    public String decirChau(@RequestParam String nombre,
                            @RequestParam String apellido,
                            @RequestParam int edad){
        return "Chau " + nombre + " " + apellido + " de " + edad + " años.";
    }//Ejemplo:    localhost:8080/chau?nombre=Leandro&apellido=Quipildor&edad=41
    
    @PostMapping ("/new/persona")
    public void agregarPersona (@RequestBody Persona pers) {
        listaPersonas.add(pers);
    }/* Ejemplo en POSTMAN - Método POST
        localhost:8080/new/persona
    
        en el cuerpo mandar el JSON:
    
        {
            "id" : 1,
            "nombre" : "Luffy",
            "apellido" : "Monkey D."
        }
    
        Si después vamos a localhost:8080/ver/personas  podremos comprobar el resultado    
    */
/*    
    @GetMapping ("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas() {
        return listaPersonas;
    }/* Ejemplo en POSTMAN - Método GET
        localhost:8080/ver/personas
    
        Nos va a mostrar la lista de personas, si solo ingresamos la del 
        ejemplo anterior mostrará:
    
        [
            {
                "id" : 1,
                "nombre" : "Luffy",
                "apellido" : "Monkey D."
            }
        ]
    
    */
    
}
