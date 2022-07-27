package com.quipildor.portfolio.controller;

import java.util.List;

import com.quipildor.portfolio.dto.ImgProyDTO;
import com.quipildor.portfolio.dto.Mensaje;
import com.quipildor.portfolio.interfaz.IImgProyService;
import com.quipildor.portfolio.model.ImgProy;

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
@RequestMapping("/imagen")
public class ImgProyController {

    @Autowired IImgProyService iimgServ;

    @GetMapping ("/invitado")
    public ResponseEntity<List<ImgProy>> listarImagenesProyecto() {
        List<ImgProy> listaImagenes = iimgServ.listarImagenesProy();
        return new ResponseEntity<List<ImgProy>>(listaImagenes, HttpStatus.OK);
    }

    @GetMapping ("/invitado/{idProy}")
    public ResponseEntity<List<ImgProy>> listarImagenesDeUnProyecto(@PathVariable Long idProy) {
        List<ImgProy> listaImagenes = iimgServ.listarImagenesDeUnProyecto(idProy);
        return new ResponseEntity<List<ImgProy>>(listaImagenes, HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> buscarImagenProy(@PathVariable Long id) {
        if(!iimgServ.existeImagenProy(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("Id No Existe"), HttpStatus.NOT_FOUND);
        }
        ImgProy imagen = iimgServ.buscarImagenProy(id);
        return new ResponseEntity<ImgProy>(imagen, HttpStatus.OK);
    }

    @PostMapping ("/crear")
    public ResponseEntity<?> altaImagenProy(@RequestBody ImgProyDTO imgProyDto){
        ImgProy imagen = new ImgProy(imgProyDto.getIdImgProy(), imgProyDto.getIdUrlImg(),imgProyDto.getUrlImg(),
                                imgProyDto.getProyecto_id());
        iimgServ.crearImagenProy(imagen);
        return new ResponseEntity<Mensaje>(new Mensaje("La imagen fue subida."), HttpStatus.OK);
    }    

    @PutMapping ("/editar/{id}")
    public ResponseEntity<?> modificarImagenProy(@PathVariable Long id, @RequestBody ImgProyDTO imgProyDto){
        if(!iimgServ.existeImagenProy(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("El Id No Existe"), HttpStatus.NOT_FOUND);
        }
        ImgProy imagen = iimgServ.buscarImagenProy(id);

        imagen.setIdImgProy(imgProyDto.getIdImgProy());
        imagen.setIdUrlImg(imgProyDto.getIdUrlImg());
        imagen.setUrlImg(imgProyDto.getUrlImg());
        imagen.setProyecto_id(imgProyDto.getProyecto_id());

        iimgServ.crearImagenProy(imagen);

        return new ResponseEntity<Mensaje>(new Mensaje("Imagen actualizada."), HttpStatus.OK);
    }

    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<?> borrarImagenProy(@PathVariable Long id){
        if(!iimgServ.existeImagenProy(id)){
            return new ResponseEntity<Mensaje>(new Mensaje("El Id No Existe"), HttpStatus.NOT_FOUND);
        }
        iimgServ.borrarImagenProy(id);
        return new ResponseEntity<Mensaje>(new Mensaje("La imagen fue borrada."), HttpStatus.OK);
    }
    
}
