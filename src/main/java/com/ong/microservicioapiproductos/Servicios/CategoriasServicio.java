package com.ong.microservicioapiproductos.Servicios;

import com.ong.microservicioapiproductos.Dto.CategoriasDTO;
import com.ong.microservicioapiproductos.Entidades.CategoriasEntidad;
import com.ong.microservicioapiproductos.Entidades.ProductosEntidad;
import com.ong.microservicioapiproductos.Repositorios.CategoriasRepositorio;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class CategoriasServicio {

    @Autowired
    private CategoriasRepositorio categoriasRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    public List<CategoriasDTO> traerCategorias(){
        List<CategoriasEntidad> categoriasEntidads = categoriasRepositorio.findAll();
        Type listType = new TypeToken<List<CategoriasDTO>>(){}.getType();
        List<CategoriasDTO> categoriasDTOS = modelMapper.map(categoriasEntidads,listType);
        return categoriasDTOS;
    }
}
