package com.example.agitana.models;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "almacen_usuario", schema ="AGitana" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Almacen_usuario {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_almacen")
    private com.example.agitana.models.almacen almacen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private com.example.agitana.models.usuario usuario;

}
