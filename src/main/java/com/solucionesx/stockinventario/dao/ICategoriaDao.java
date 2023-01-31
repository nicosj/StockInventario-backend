package com.solucionesx.stockinventario.dao;

import com.solucionesx.stockinventario.models.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface ICategoriaDao extends CrudRepository<Categoria, Long> {

}
