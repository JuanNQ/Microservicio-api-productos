package com.ong.microservicioapiproductos.Controladores;


import com.ong.microservicioapiproductos.Dto.CategoriasDTO;
import com.ong.microservicioapiproductos.Servicios.CategoriasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/categorias")
public class CategoriasControlador {

    @Autowired
    private CategoriasServicio categoriasServicio;

    @GetMapping("/traerCategorias")
    public ResponseEntity<List<CategoriasDTO>> traerCategorias(){
        try{
            return new ResponseEntity<>(categoriasServicio.traerCategorias(),HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
