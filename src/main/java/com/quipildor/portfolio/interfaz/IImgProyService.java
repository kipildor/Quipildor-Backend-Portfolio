package com.quipildor.portfolio.interfaz;

import java.util.List;

import com.quipildor.portfolio.model.ImgProy;

public interface IImgProyService {
    
    //Trae una lista con las imagenes del proyecto
    public List<ImgProy> listarImagenesProy();

    //Crea un registro para una nueva imagen del proyecto
    public void crearImagenProy(ImgProy imagen);

    //Borra el registro de una imagen del proyecto
    public void borrarImagenProy(Long id);

    //Trae el registro de la imagen que coincide con el ID
    public ImgProy buscarImagenProy(Long id);

    //Actualiza el registro de una imagen
    public void actualizarImagenProy(ImgProy imagen);

    //Comprueba si existe la imagen
    public boolean existeImagenProy(Long id);
    
}
