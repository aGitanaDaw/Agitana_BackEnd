package com.example.agitana.models;

import com.example.agitana.enums.TipoSolicitud;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "donacion", schema ="public" )
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @Column(name = "estado")
    @Enumerated(EnumType.ORDINAL)
    private TipoSolicitud estado;

}
