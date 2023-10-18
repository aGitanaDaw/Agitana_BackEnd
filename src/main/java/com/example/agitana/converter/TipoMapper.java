package com.example.agitana.converter;

import com.example.agitana.dto.TipoDTO;
import com.example.agitana.models.Tipo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoMapper {

    TipoDTO toDTO(Tipo entity);

    Tipo toEntity(TipoDTO dto);

    List<TipoDTO> toDTO(List<Tipo> listEntity);

    List<Tipo> toEntity(List<TipoDTO> listDTOs);
}
