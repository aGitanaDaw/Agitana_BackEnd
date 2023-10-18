package com.example.agitana.converter;


import com.example.agitana.dto.CategoriaDTO;
import com.example.agitana.models.Categoria;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaDTO toDTO(Categoria entity);

    Categoria toEntity(CategoriaDTO dto);

    List<CategoriaDTO> toDTO(List<Categoria> listEntity);

    List<Categoria> toEntity(List<CategoriaDTO> listDTOs);
}
