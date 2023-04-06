package com.ong.microservicioapiproductos.Controladores;

import com.ong.microservicioapiproductos.Dto.ProductosTotalesDTO;
import com.ong.microservicioapiproductos.Servicios.ProductosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/productos")
public class ProductosControlador {

    @Autowired
    private ProductosServicio productosServicio;

//    @GetMapping("/listarProductos")
//    public ResponseEntity<?> traerProductos(){
//        try{
//            return new ResponseEntity<>(productosServicio.traerProductos(), HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    @GetMapping("/listarProductosPaginados")
    public ResponseEntity<Page<ProductosTotalesDTO>> traerProductosPaginados(@RequestParam(name = "page") int page,
                                                                             @RequestParam(name = "size") int size){
        try{
            return new ResponseEntity<>(productosServicio.traerProductosPaginados(PageRequest.of(page,size)),
                    HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductosTotalesDTO> traerProducto(@PathVariable(name = "id") int id){
        try{
            return new ResponseEntity<>(productosServicio.traerProducto(id),HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}/productos")
    public ResponseEntity<Page<ProductosTotalesDTO>> traerProductosPorCategoriaPaginados(@PathVariable(name = "id") String id,
                                                                                         @RequestParam(name = "page") int page,
                                                                                         @RequestParam(name = "size") int size){
        try{
            return new ResponseEntity<>(productosServicio.productosPorCategoria(id, PageRequest.of(page,size)), HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
