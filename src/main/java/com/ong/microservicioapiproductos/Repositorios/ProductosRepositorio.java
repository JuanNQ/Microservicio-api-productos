package com.ong.microservicioapiproductos.Repositorios;

import com.ong.microservicioapiproductos.Entidades.CategoriasEntidad;
import com.ong.microservicioapiproductos.Entidades.ProductosEntidad;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepositorio extends JpaRepository<ProductosEntidad, Integer> {

    @Query(value = "select pd from ProductosEntidad pd where nombre like %:nombre%")
    Page<ProductosEntidad> findByNombre(Pageable pageable, String nombre);

    Page<ProductosEntidad> findByCategoria(CategoriasEntidad categoria, Pageable pageable);

    @Query(value = "select pd from ProductosEntidad pd where categoria=:categoria order by precio desc")
    Page<ProductosEntidad> traerProductosPorCategoriasDesc(CategoriasEntidad categoria, Pageable pageable);

    @Query(value = "select pd from ProductosEntidad pd where categoria=:categoria order by precio asc")
    Page<ProductosEntidad> traerProductosPorCategoriasAsc(CategoriasEntidad categoria, Pageable pageable);

    @Query(value = "select pd from ProductosEntidad pd where categoria=:categoria and nombre like %:nombre%")
    Page<ProductosEntidad> traerProductosPorCategoriasSearch(CategoriasEntidad categoria, Pageable pageable, String nombre);

    @Query(value = "select pd from ProductosEntidad pd where categoria=:categoria and nombre like %:nombre% order by precio desc")
    Page<ProductosEntidad> traerProductosPorCategoriasSearchDesc(CategoriasEntidad categoria, Pageable pageable, String nombre);

    @Query(value = "select pd from ProductosEntidad pd where categoria=:categoria and nombre like %:nombre% order by precio asc")
    Page<ProductosEntidad> traerProductosPorCategoriasSearchAsc(CategoriasEntidad categoria, Pageable pageable, String nombre);

    @Query(value = "select pd from ProductosEntidad pd order by precio desc")
    Page<ProductosEntidad> traerProductosPorFiltroDesc(Pageable pageable);

    @Query(value = "select pd from ProductosEntidad pd order by precio asc")
    Page<ProductosEntidad> traerProductosPorFiltroAsc(Pageable pageable);

    @Query(value = "select pd from ProductosEntidad pd where nombre like %:nombre% order by precio desc")
    Page<ProductosEntidad> traerProductosPorFiltroSearchDesc(Pageable pageable, String nombre);

    @Query(value = "select pd from ProductosEntidad pd where nombre like %:nombre% order by precio asc")
    Page<ProductosEntidad> traerProductosPorFiltroSearchAsc(Pageable pageable, String nombre);

}
