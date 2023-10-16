package com.example.agitana.models;

import com.example.agitana.enums.TipoPersona;
import com.example.agitana.enums.TipoRol;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario", schema ="AGitana" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class usuario {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "contrasenya")
    private String contrasenya;

    @Column(name = "rol")
    @Enumerated(EnumType.ORDINAL)
    private TipoRol tiporol;

}
