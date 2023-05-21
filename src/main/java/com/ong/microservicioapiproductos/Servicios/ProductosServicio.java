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

//    public Page<ProductosTotalesDTO> traerProductosPaginados(Pageable pageable){
//        Page<ProductosEntidad> productos = productosRepositorio.findAll(pageable);
//        Page<ProductosTotalesDTO> productosTotalesDTOS = productos.map(objectEntity -> modelMapper.map(objectEntity, ProductosTotalesDTO.class));
//
//        return productosTotalesDTOS;
//    }

    public Page<ProductosTotalesDTO> traerProductosPaginados(Pageable pageable, int filtro){
//        Page<ProductosEntidad> productos = filtro == 0? productosRepositorio.findAll(pageable):productosRepositorio.traerProductosPorFiltroDesc(pageable);
        Page<ProductosEntidad> productos = null;
        if(filtro == 0){
            productos = productosRepositorio.findAll(pageable);
        } else if (filtro == 2) {
            productos = productosRepositorio.traerProductosPorFiltroDesc(pageable);
        } else if (filtro == 1) {
            productos = productosRepositorio.traerProductosPorFiltroAsc(pageable);
        }

        Page<ProductosTotalesDTO> productosTotalesDTOS = productos.map(objectEntity -> modelMapper.map(objectEntity, ProductosTotalesDTO.class));

        return productosTotalesDTOS;
    }

    public ProductosTotalesDTO traerProducto(int id){
        ProductosEntidad productosEntidad = productosRepositorio.findById(id).orElseThrow(null);
//        return productosRepositorio.findById(id).orElseThrow(null);
        return modelMapper.map(productosEntidad, ProductosTotalesDTO.class);
    }

    public Page<ProductosTotalesDTO> productosPorCategoria(String id, Pageable pageable, int filtro){
        CategoriasEntidad categoriasEntidad = categoriasRepositorio.findById(Integer.valueOf(id)).orElseThrow(null);
//        Page<ProductosEntidad> productosEntidad = productosRepositorio.findByCategoria(categoriasEntidad, pageable);
        Page<ProductosEntidad> productos = null;
        if(filtro == 0){
            productos = productosRepositorio.findByCategoria(categoriasEntidad, pageable);
        } else if (filtro == 2) {
            productos = productosRepositorio.traerProductosPorCategoriasDesc(categoriasEntidad, pageable);
        } else if (filtro == 1) {
            productos = productosRepositorio.traerProductosPorCategoriasAsc(categoriasEntidad, pageable);
        }

        Page<ProductosTotalesDTO> productosTotalesDTOS = productos.map(objectEntity -> modelMapper.map(objectEntity, ProductosTotalesDTO.class));
        return productosTotalesDTOS;
    }
}
