package com.example.agitana.converter;

import com.example.agitana.dto.AlmacenDTO;
import com.example.agitana.models.Almacen;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-19T18:50:19+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class AlmacenMapperImpl implements AlmacenMapper {

    @Override
    public AlmacenDTO toDTO(Almacen entity) {
        if ( entity == null ) {
            return null;
        }

        AlmacenDTO almacenDTO = new AlmacenDTO();

        almacenDTO.setId( entity.getId() );
        almacenDTO.setNombre( entity.getNombre() );
        almacenDTO.setFecha_entrada( entity.getFecha_entrada() );

        return almacenDTO;
    }

    @Override
    public Almacen toEntity(AlmacenDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Almacen almacen = new Almacen();

        almacen.setId( dto.getId() );
        almacen.setNombre( dto.getNombre() );
        almacen.setFecha_entrada( dto.getFecha_entrada() );

        return almacen;
    }

    @Override
    public List<AlmacenDTO> toDTO(List<Almacen> listEntity) {
        if ( listEntity == null ) {
            return null;
        }

        List<AlmacenDTO> list = new ArrayList<AlmacenDTO>( listEntity.size() );
        for ( Almacen almacen : listEntity ) {
            list.add( toDTO( almacen ) );
        }

        return list;
    }

    @Override
    public List<Almacen> toEntity(List<AlmacenDTO> listDTOs) {
        if ( listDTOs == null ) {
            return null;
        }

        List<Almacen> list = new ArrayList<Almacen>( listDTOs.size() );
        for ( AlmacenDTO almacenDTO : listDTOs ) {
            list.add( toEntity( almacenDTO ) );
        }

        return list;
    }
}
