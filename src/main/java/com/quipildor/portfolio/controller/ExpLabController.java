package com.quipildor.portfolio.controller;

import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import com.quipildor.portfolio.cloudinary.entity.Imagen;
import com.quipildor.portfolio.cloudinary.service.CloudinaryService;
import com.quipildor.portfolio.cloudinary.service.ImagenService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/exp")
public class ExpLabController {

    @Autowired IExpLabService iexpServ;
    @Autowired ImagenService imgServ;
    @Autowired CloudinaryService cloudyServ;

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
                                expLabDto.getUrlLogo(), expLabDto.getPersona_id());
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
        expLab.setPersona_id(expLabDto.getPersona_id());

        iexpServ.crearExpLab(expLab);

        return new ResponseEntity<Mensaje>(new Mensaje("Experiencia actualizada."), HttpStatus.OK);
    }

    /************************************************************************************** */
    @PostMapping ("/crearconlogo")
    public ResponseEntity<?> altaExperienciaConLogo(@RequestBody ExpLabDTO expLabDto, @RequestParam MultipartFile multipartFile)throws IOException {
        //*******************************************************
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if(bi == null){
            return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudyServ.upload(multipartFile);
        Imagen imagen =
                new Imagen((String)result.get("original_filename"),
                        (String)result.get("url"),
                        (String)result.get("public_id"));
        //System.out.println(imagen.getImagenUrl());
        imgServ.save(imagen); 
        //*******************************************************
        /* ExpLab experiencia = new ExpLab(expLabDto.getIdExp(), expLabDto.getNombreEmp(), expLabDto.getFechaIng(),
                                expLabDto.getFechaSalida(), expLabDto.getDescripcion(), expLabDto.getIdUrlLogo(),
                                expLabDto.getUrlLogo(), expLabDto.getPerso()); */
        ExpLab experiencia = new ExpLab(expLabDto.getIdExp(), expLabDto.getNombreEmp(), expLabDto.getFechaIng(),
                                expLabDto.getFechaSalida(), expLabDto.getDescripcion(), expLabDto.getIdUrlLogo(),
                                imagen.getImagenUrl(), expLabDto.getPersona_id());
        iexpServ.crearExpLab(experiencia);
        return new ResponseEntity<Mensaje>(new Mensaje("La experiencia fue agregada."), HttpStatus.OK);
    }

    
}
