package com.example.agitana.converter;

import com.example.agitana.dto.CategoriaDTO;
import com.example.agitana.models.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-18T12:22:37+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public CategoriaDTO toDTO(Categoria entity) {
        if ( entity == null ) {
            return null;
        }

        CategoriaDTO categoriaDTO = new CategoriaDTO();

        categoriaDTO.setId( entity.getId() );
        categoriaDTO.setNombre( entity.getNombre() );
        categoriaDTO.setDescripcion( entity.getDescripcion() );

        return categoriaDTO;
    }

    @Override
    public Categoria toEntity(CategoriaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setId( dto.getId() );
        categoria.setNombre( dto.getNombre() );
        categoria.setDescripcion( dto.getDescripcion() );

        return categoria;
    }

    @Override
    public List<CategoriaDTO> toDTO(List<Categoria> listEntity) {
        if ( listEntity == null ) {
            return null;
        }

        List<CategoriaDTO> list = new ArrayList<CategoriaDTO>( listEntity.size() );
        for ( Categoria categoria : listEntity ) {
            list.add( toDTO( categoria ) );
        }

        return list;
    }

    @Override
    public List<Categoria> toEntity(List<CategoriaDTO> listDTOs) {
        if ( listDTOs == null ) {
            return null;
        }

        List<Categoria> list = new ArrayList<Categoria>( listDTOs.size() );
        for ( CategoriaDTO categoriaDTO : listDTOs ) {
            list.add( toEntity( categoriaDTO ) );
        }

        return list;
    }
}
