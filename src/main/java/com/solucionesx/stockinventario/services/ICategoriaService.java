package com.solucionesx.stockinventario.services;

import com.solucionesx.stockinventario.models.Categoria;
import com.solucionesx.stockinventario.response.CategoriaResponseRest;
import org.springframework.http.ResponseEntity;

public interface ICategoriaService {
    public ResponseEntity<CategoriaResponseRest> search();
    public ResponseEntity<CategoriaResponseRest> searchById(Long id);
    public ResponseEntity<CategoriaResponseRest> Save(Categoria categoria);

}
