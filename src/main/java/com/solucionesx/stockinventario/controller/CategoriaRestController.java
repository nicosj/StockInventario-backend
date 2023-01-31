package com.solucionesx.stockinventario.controller;

import com.solucionesx.stockinventario.response.CategoriaResponseRest;
import com.solucionesx.stockinventario.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CategoriaRestController {

    @Autowired
    private ICategoriaService service;

    @GetMapping("/categorias")
    public ResponseEntity<CategoriaResponseRest> searchCategoria(){
         ResponseEntity<CategoriaResponseRest> responseEntity = service.search();
         return responseEntity;
    }
}
