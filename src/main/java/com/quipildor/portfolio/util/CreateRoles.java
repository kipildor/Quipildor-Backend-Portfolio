package com.quipildor.portfolio.util;

import com.quipildor.portfolio.model.Estado;
import com.quipildor.portfolio.model.Persona;
import com.quipildor.portfolio.security.entity.Rol;
import com.quipildor.portfolio.security.enums.RolNombre;
import com.quipildor.portfolio.security.service.RolService;
import com.quipildor.portfolio.service.ImpEstadoService;
import com.quipildor.portfolio.service.ImpPersonaService;

//import java.sql.Date;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */
/* 
@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Autowired
    ImpPersonaService persoService;

    @Autowired
    ImpEstadoService estadoService;

    @Override
    public void run(String... args) throws Exception {
        Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        rolService.save(rolAdmin);
        rolService.save(rolUser);
        
        Persona primerPersona = new Persona();
        primerPersona.setEmail("leandro_1980@live.com.ar");
        primerPersona.setPassword("1234");
        persoService.crearPersona(primerPersona);

        Estado estadoAbandonado = new Estado(1, "Abandonada/o");
        Estado estadoCursando = new Estado(2, "Cursando");
        Estado estadoCompletado = new Estado(3, "Completada/o");
        estadoService.crearEstado(estadoAbandonado);
        estadoService.crearEstado(estadoCursando);
        estadoService.crearEstado(estadoCompletado);

    }
} */

/****  En Postman podemos crear un usuario así:
 * Método POST ** localhost:8080/auth/nuevo
 * 
 * Seleccionamos Body -> raw
 * 
 * Y seleccionamos que sea tipo JSON, después para un usuario común, tipo "user" escribimos:
 * 
 * {"nombre": "user", "nombreUsuario": "user@gmail.com.ar", "email": "user@gmail.com.ar", "password": "user", "roles": ["user"]}
 */