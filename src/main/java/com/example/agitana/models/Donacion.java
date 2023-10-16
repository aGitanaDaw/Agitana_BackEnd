package com.example.agitana.models;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "donacion", schema ="AGitana" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Donacion {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion_producto")
    private String descripcion_producto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "id_tipo")
    private Integer id_tipo;

    @Column(name = "id_persona")
    private Integer id_persona;

    @Column(name = "estado")
    private String estado;

    public Donacion(Integer cantidad, String descripcionProducto, Integer idTipo, Integer idPersona, String estado) {
    }
}
