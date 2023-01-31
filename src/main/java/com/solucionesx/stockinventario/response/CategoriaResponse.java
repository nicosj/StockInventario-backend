package com.solucionesx.stockinventario.response;

import com.solucionesx.stockinventario.models.Categoria;
import lombok.Data;

import java.util.List;
@Data
public class CategoriaResponse {
    private List<Categoria> categorias;

}
