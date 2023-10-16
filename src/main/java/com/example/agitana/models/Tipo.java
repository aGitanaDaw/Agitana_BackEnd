package com.example.agitana.models;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "tipo", schema ="AGitana" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Tipo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;
}
