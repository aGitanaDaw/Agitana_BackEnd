package com.example.agitana.models;

import com.example.agitana.enums.TipoPersona;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "persona", schema ="AGitana" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class persona {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido_primero")
    private String apellido_primero;

    @Column(name = "apellido_segundo")
    private String apellido_segundo;

    @Column(name = "dni")
    private String dni;

    @Column(name = "tipo")
    @Enumerated(EnumType.ORDINAL)
    private TipoPersona tipo;


}
