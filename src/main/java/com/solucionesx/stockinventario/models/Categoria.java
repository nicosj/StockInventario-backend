package com.solucionesx.stockinventario.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="categorias")
public class Categoria implements Serializable {

    private static final long serialVersionUID = -4310027227752446841L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String descripcion;




}
