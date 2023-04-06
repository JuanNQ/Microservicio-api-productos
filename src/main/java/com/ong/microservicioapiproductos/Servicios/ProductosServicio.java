package com.ong.microservicioapiproductos.Servicios;

import com.ong.microservicioapiproductos.Dto.ProductosTotalesDTO;
import com.ong.microservicioapiproductos.Entidades.CategoriasEntidad;
import com.ong.microservicioapiproductos.Entidades.ProductosEntidad;
import com.ong.microservicioapiproductos.Repositorios.CategoriasRepositorio;
import com.ong.microservicioapiproductos.Repositorios.ProductosRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosServicio {

    @Autowired
    private ProductosRepositorio productosRepositorio;

    @Autowired
    private CategoriasRepositorio categoriasRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductosEntidad> traerProductos(){
        return productosRepositorio.findAll();
    }

    public Page<ProductosTotalesDTO> traerProductosPaginados(Pageable pageable){
        Page<ProductosEntidad> productos = productosRepositorio.findAll(pageable);
        Page<ProductosTotalesDTO> productosTotalesDTOS = productos.map(objectEntity -> modelMapper.map(objectEntity, ProductosTotalesDTO.class));

        return productosTotalesDTOS;
    }

    public ProductosTotalesDTO traerProducto(int id){
        ProductosEntidad productosEntidad = productosRepositorio.findById(id).orElseThrow(null);
//        return productosRepositorio.findById(id).orElseThrow(null);
        return modelMapper.map(productosEntidad, ProductosTotalesDTO.class);
    }

    public Page<ProductosTotalesDTO> productosPorCategoria(String id, Pageable pageable){
        CategoriasEntidad categoriasEntidad = categoriasRepositorio.findById(Integer.valueOf(id)).orElseThrow(null);
        Page<ProductosEntidad> productosEntidad = productosRepositorio.findByCategoria(categoriasEntidad, pageable);
        Page<ProductosTotalesDTO> productosTotalesDTOS = productosEntidad.map(objectEntity -> modelMapper.map(objectEntity, ProductosTotalesDTO.class));
        return productosTotalesDTOS;
    }
}
