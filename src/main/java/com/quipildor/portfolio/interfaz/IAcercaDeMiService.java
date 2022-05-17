package com.quipildor.portfolio.interfaz;

import java.util.List;

import com.quipildor.portfolio.model.AcercaDeMi;

public interface IAcercaDeMiService {

    //Trae una lista con todos los registros de AcercaDeMi
    public List<AcercaDeMi> listarParrafos();

    //Crea un nuevo párrafo AcercaDeMi
    public void crearParrafo(AcercaDeMi parrafo);

    //Borra un párrafo que coincida con el ID
    public void borrarParrafo(Long id);

    //Trae el parrafo que coincida con el ID
    public AcercaDeMi buscarParrafo(Long id);

    //Actualiza el parrafo
    public void actualizarParrafo(AcercaDeMi parrafo);
    

}
