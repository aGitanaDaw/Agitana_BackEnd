package com.example.agitana.models;

import com.example.agitana.enums.TipoPersona;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "persona", schema ="public" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Persona {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido_Primero")
    private String apellido_Primero;

    @Column(name = "apellido_Segundo")
    private String apellido_Segundo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "dni")
    private String dni;

    @Column(name = "tipo_Persona")
    @Enumerated(EnumType.ORDINAL)
    private TipoPersona tipoPersona;


}
