package com.solucionesx.stockinventario.controller;

import com.solucionesx.stockinventario.models.Categoria;
import com.solucionesx.stockinventario.response.CategoriaResponseRest;
import com.solucionesx.stockinventario.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
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

    /**
     *
     * @param categoria
     * @return
     */
    @PostMapping("/categorias")
    public ResponseEntity<CategoriaResponseRest> save(@RequestBody Categoria categoria) {
        ResponseEntity<CategoriaResponseRest> responseEntity = service.Save(categoria);
        return responseEntity;
    }
    /**
     *
     * @param id
     * @param categoria
     * @return
     */
    @PutMapping("/categorias/{id}")
    public ResponseEntity<CategoriaResponseRest> update(@PathVariable Long id, @RequestBody Categoria categoria) {
        ResponseEntity<CategoriaResponseRest> responseEntity = service.Update(id,categoria);
        return responseEntity;
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<CategoriaResponseRest> update(@PathVariable Long id) {
        ResponseEntity<CategoriaResponseRest> responseEntity = service.deleteById(id);
        return responseEntity;
    }
}
