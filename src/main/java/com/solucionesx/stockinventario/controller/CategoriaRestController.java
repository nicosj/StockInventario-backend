package com.solucionesx.stockinventario.controller;

import com.solucionesx.stockinventario.response.CategoriaResponseRest;
import com.solucionesx.stockinventario.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CategoriaRestController {

    @Autowired
    private ICategoriaService service;

    /**
     * Busca todas las categorias
     * @return
     */
    @GetMapping("/categorias")
    public ResponseEntity<CategoriaResponseRest> searchCategoria(){
         ResponseEntity<CategoriaResponseRest> responseEntity = service.search();
         return responseEntity;
    }

    /**
     * Busca una categoria por id
     * @param id
     * @return
     */
    @GetMapping("/categorias/{id}")
    public ResponseEntity<CategoriaResponseRest> searchCategoriaById(@PathVariable Long id) {
        ResponseEntity<CategoriaResponseRest> responseEntity = service.searchById(id);
        return responseEntity;
    }

    }
