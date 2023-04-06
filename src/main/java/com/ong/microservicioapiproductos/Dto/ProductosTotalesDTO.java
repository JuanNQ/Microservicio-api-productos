package com.ong.microservicioapiproductos.Dto;

import com.ong.microservicioapiproductos.Entidades.CategoriasEntidad;
import lombok.Data;

@Data
public class ProductosTotalesDTO {
    private Integer id;
    private String nombre;
    private Integer precio;
    private String descripcion;
    private String imagen;
    private CategoriasEntidad categoria;
}
