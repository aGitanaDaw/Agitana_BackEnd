package com.example.agitana.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.tool.schema.extract.spi.ColumnInformation;

import java.util.Date;

@Entity
@Table(name = "almacen", schema ="AGitana" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class almacen {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_entrada")
    private Date fecha_entrada;
}
