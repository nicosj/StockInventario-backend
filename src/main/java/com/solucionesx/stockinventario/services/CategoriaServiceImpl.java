package com.solucionesx.stockinventario.services;

import com.solucionesx.stockinventario.dao.ICategoriaDao;
import com.solucionesx.stockinventario.models.Categoria;
import com.solucionesx.stockinventario.response.CategoriaResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

    @Autowired
    private ICategoriaDao categoriaDao;
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoriaResponseRest> search() {
        CategoriaResponseRest response = new CategoriaResponseRest();
        try {
            List<Categoria> categorias =(List<Categoria>) categoriaDao.findAll();
            response.getData().setCategorias(categorias);
            response.setMetadata("Respuesta ok", "200", "Respuesta exitosa");

        } catch (Exception e) {
            response.setMetadata("Error", "500", "Error al consultar las categorias");
            e.getStackTrace();
            return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
    }
}
