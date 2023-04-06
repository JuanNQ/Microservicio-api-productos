package com.ong.microservicioapiproductos.Entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productos")
public class ProductosEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private Integer precio;

    private String descripcion;

    private String imagen;

    @Column(name = "fecha_Creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_Modif")
    private LocalDateTime fechaModificacion;

    @JoinColumn(name = "categoria_id")
    @ManyToOne
    private CategoriasEntidad categoria;

    private Integer stock;

    private String codigo;

    private Boolean estado;

}
