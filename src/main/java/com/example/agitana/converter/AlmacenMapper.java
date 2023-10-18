package com.example.agitana.converter;

import com.example.agitana.dto.AlmacenDTO;
import com.example.agitana.dto.CategoriaDTO;
import com.example.agitana.models.Almacen;
import com.example.agitana.models.Categoria;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlmacenMapper {
    AlmacenDTO toDTO(Almacen entity);

    Almacen toEntity(AlmacenDTO dto);

    List<AlmacenDTO> toDTO(List<Almacen> listEntity);

    List<Almacen> toEntity(List<AlmacenDTO> listDTOs);
}
