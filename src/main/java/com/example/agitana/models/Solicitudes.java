package com.example.agitana.models;
import com.example.agitana.enums.TipoSolicitud;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "solicitudes", schema ="public" , catalog = "postgres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Solicitudes {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "estado")
    @Enumerated(EnumType.ORDINAL)
    private TipoSolicitud tipoSolicitud;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_almacen")
    private Almacen almacen;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}
