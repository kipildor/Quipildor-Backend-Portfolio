package com.quipildor.portfolio.cloudinary.controller;

import com.quipildor.portfolio.cloudinary.dto.Mensaje;
import com.quipildor.portfolio.cloudinary.entity.Imagen;
import com.quipildor.portfolio.cloudinary.service.CloudinaryService;
import com.quipildor.portfolio.cloudinary.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cloudinary")
@CrossOrigin
public class MainController {

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    ImagenService imagenService;

    @GetMapping("/invitado/list")
    public ResponseEntity<List<Imagen>> list(){
        List<Imagen> list = imagenService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/uploadFotoPerfil")
    public ResponseEntity<?> uploadFotoPerfil(@RequestParam MultipartFile multipartFile)throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if(bi == null){
            return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryService.upload(multipartFile);
        Imagen imagen =
                new Imagen((String)result.get("original_filename"),
                        (String)result.get("url"),
                        (String)result.get("public_id"));
        //System.out.println(imagen.getImagenUrl());
        imagenService.save(imagen);
        return new ResponseEntity(new Mensaje("imagen subida"), HttpStatus.OK);
        //return new ResponseEntity<Imagen>(imagen, HttpStatus.OK);
    }

    @PostMapping("/uploadLogoEmpresa")
    public ResponseEntity<?> uploadLogoEmpresa(@RequestParam MultipartFile multipartFile)throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if(bi == null){
            return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryService.upload(multipartFile);
        Imagen imagen =
                new Imagen((String)result.get("original_filename"),
                        (String)result.get("url"),
                        (String)result.get("public_id"));
        //System.out.println(imagen.getImagenUrl());
        imagenService.save(imagen);
        //return new ResponseEntity(new Mensaje("imagen subida"), HttpStatus.OK);
        return new ResponseEntity(imagen, HttpStatus.OK);
    }

    @PostMapping("/uploadFotoProyecto")
    public ResponseEntity<?> uploadFotoProyecto(@RequestParam MultipartFile multipartFile)throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if(bi == null){
            return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryService.upload(multipartFile);
        Imagen imagen =
                new Imagen((String)result.get("original_filename"),
                        (String)result.get("url"),
                        (String)result.get("public_id"));
        //System.out.println(imagen.getImagenUrl());
        imagenService.save(imagen);
        return new ResponseEntity(new Mensaje("imagen subida"), HttpStatus.OK);
        //return new ResponseEntity<Imagen>(imagen, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id)throws IOException {
        if(!imagenService.exists(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Imagen imagen = imagenService.getOne(id).get();
        Map result = cloudinaryService.delete(imagen.getImagenId());
        imagenService.delete(id);
        return new ResponseEntity(new Mensaje("imagen eliminada"), HttpStatus.OK);
    }

    /**************************************************** */
    /* @GetMapping("/invitado/imagen_url/{imagen_url}")
    public ResponseEntity<?> getByURL(@PathVariable("imagen_url") String imagen_url) throws IOException {
        if(!imagenService.existsImgByURL(imagen_url))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Imagen img = imagenService.getImgByURL(imagen_url);
        return new ResponseEntity(img, HttpStatus.OK);
    } */

    @GetMapping("/invitado/existeimgbyid/{id}")
    public ResponseEntity<?> existeLaImgByID(@PathVariable("id") int id) {
        boolean existe = imagenService.exists(id);
        return new ResponseEntity(existe, HttpStatus.OK);
    }

    /* @GetMapping("/invitado/traer/{id}")
    public ResponseEntity<?> getImagenByID(@PathVariable("id") int id) {
        if(!imagenService.exists(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Imagen imagen = imagenService.getById(id);
        return new ResponseEntity(imagen, HttpStatus.OK);
    } */

    @GetMapping("/invitado/traer/{id}")
    public ResponseEntity<?> buscarImagen(@PathVariable int id) {
        if(!imagenService.exists(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("Id No Existe"), HttpStatus.NOT_FOUND);
        }
        Imagen img = imagenService.getById(id);
        return new ResponseEntity<Imagen>(img, HttpStatus.OK);
    }

    /* @GetMapping("/invitado/existeimgbyurl/{imagenUrl}")
    public ResponseEntity<?> existeLaImgByURL(@PathVariable("imagenUrl") String imagenUrl) {

            //System.out.println(imagenUrl);
        String direccionBase = imagenUrl.substring(imagenUrl.indexOf("//")+1);
        boolean existe = imagenService.existsImgByURL(direccionBase);
        return new ResponseEntity(existe, HttpStatus.OK);
    } */
    
    @GetMapping("/invitado/existeimgbyidcloudy/{cloudy_id}")
    public ResponseEntity<?> existsByIDCloudinary(@PathVariable("cloudy_id") String cloudy_id) {
        
        boolean existe = imagenService.existsByIDCloudinary(cloudy_id);
        return new ResponseEntity(existe, HttpStatus.OK);
    }
}
