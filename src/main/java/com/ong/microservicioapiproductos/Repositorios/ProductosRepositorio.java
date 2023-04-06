package com.ong.microservicioapiproductos.Repositorios;

import com.ong.microservicioapiproductos.Entidades.CategoriasEntidad;
import com.ong.microservicioapiproductos.Entidades.ProductosEntidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepositorio extends JpaRepository<ProductosEntidad, Integer> {

    Page<ProductosEntidad> findByCategoria(CategoriasEntidad categoria, Pageable pageable);

}
