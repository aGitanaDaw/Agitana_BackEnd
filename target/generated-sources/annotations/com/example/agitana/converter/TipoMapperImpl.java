package com.example.agitana.converter;

import com.example.agitana.dto.TipoDTO;
import com.example.agitana.models.Tipo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-20T18:48:38+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class TipoMapperImpl implements TipoMapper {

    @Override
    public TipoDTO toDTO(Tipo entity) {
        if ( entity == null ) {
            return null;
        }

        TipoDTO tipoDTO = new TipoDTO();

        tipoDTO.setId( entity.getId() );
        tipoDTO.setNombre( entity.getNombre() );

        return tipoDTO;
    }

    @Override
    public Tipo toEntity(TipoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Tipo tipo = new Tipo();

        tipo.setId( dto.getId() );
        tipo.setNombre( dto.getNombre() );

        return tipo;
    }

    @Override
    public List<TipoDTO> toDTO(List<Tipo> listEntity) {
        if ( listEntity == null ) {
            return null;
        }

        List<TipoDTO> list = new ArrayList<TipoDTO>( listEntity.size() );
        for ( Tipo tipo : listEntity ) {
            list.add( toDTO( tipo ) );
        }

        return list;
    }

    @Override
    public List<Tipo> toEntity(List<TipoDTO> listDTOs) {
        if ( listDTOs == null ) {
            return null;
        }

        List<Tipo> list = new ArrayList<Tipo>( listDTOs.size() );
        for ( TipoDTO tipoDTO : listDTOs ) {
            list.add( toEntity( tipoDTO ) );
        }

        return list;
    }
}
