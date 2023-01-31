package com.solucionesx.stockinventario.services;

import com.solucionesx.stockinventario.dao.ICategoriaDao;
import com.solucionesx.stockinventario.models.Categoria;
import com.solucionesx.stockinventario.response.CategoriaResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoriaResponseRest> searchById(Long id) {
        CategoriaResponseRest response = new CategoriaResponseRest();
        List<Categoria> categorias = new ArrayList<>();
        try {
            Optional<Categoria> categoria = categoriaDao.findById(id);
            if(categoria.isPresent()){
                categorias.add(categoria.get());
                response.getData().setCategorias(categorias);
                response.setMetadata("Respuesta ok", "200", "Categoria encontrada");
            }else {
                response.setMetadata("Sin resultado", "200", "Categoria no encontrada");
                return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "500", "Error al consultar por id");
            e.getStackTrace();
            return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
    }

    /**
     * @param categoria
     * @return
     */
    @Override
    @Transactional
    public ResponseEntity<CategoriaResponseRest> Save(Categoria categoria) {
        CategoriaResponseRest response = new CategoriaResponseRest();
        List<Categoria> categorias = new ArrayList<>();
        try {
            Categoria categoriaSave = categoriaDao.save(categoria);
            if(categoriaSave == null){
                response.setMetadata("Error", "200", "Error al guardar la categoria");
                return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.BAD_REQUEST);
            }
            categorias.add(categoriaSave);
            response.getData().setCategorias(categorias);
            response.setMetadata("Respuesta ok", "200", "Categoria guardada");

        } catch (Exception e) {
            response.setMetadata("Error", "200", "Error al guardar la categoria");
            e.getStackTrace();
            return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
    }


}
