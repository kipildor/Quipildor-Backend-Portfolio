package com.quipildor.portfolio.service;

import java.util.List;

import com.quipildor.portfolio.interfaz.IImgProyService;
import com.quipildor.portfolio.model.ImgProy;
import com.quipildor.portfolio.repository.IImgProyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpImgProyService implements IImgProyService {

    @Autowired IImgProyRepository iimgProyRepo;

    @Override
    public List<ImgProy> listarImagenesProy() {
        List<ImgProy> listaImagenes = iimgProyRepo.findAll();
        return listaImagenes;
    }

    @Override
    public List<ImgProy> listarImagenesDeUnProyecto(long idProyecto) {
        List<ImgProy> listaImagenes = iimgProyRepo.listarImagenesDelProyecto(idProyecto);
        return listaImagenes;
    }

    @Override
    public void crearImagenProy(ImgProy imagen) {
        iimgProyRepo.save(imagen);
    }

    @Override
    public void borrarImagenProy(Long id) {
        iimgProyRepo.deleteById(id);
    }

    @Override
    public ImgProy buscarImagenProy(Long id) {
        ImgProy imagen = iimgProyRepo.findById(id).orElse(null);
        return imagen;
    }

    @Override
    public void actualizarImagenProy(ImgProy imagen) {
        iimgProyRepo.save(imagen);
    }

    @Override
    public boolean existeImagenProy(Long id) {
        return iimgProyRepo.existsById(id);
    }
    
}
