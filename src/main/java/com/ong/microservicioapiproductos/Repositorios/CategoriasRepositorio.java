package com.ong.microservicioapiproductos.Repositorios;

import com.ong.microservicioapiproductos.Entidades.CategoriasEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepositorio extends JpaRepository<CategoriasEntidad, Integer> {
}
