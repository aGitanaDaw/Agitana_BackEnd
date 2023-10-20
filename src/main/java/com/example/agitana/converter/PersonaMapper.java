package com.example.agitana.converter;

import com.example.agitana.dto.PersonaDTO;
import com.example.agitana.models.Persona;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface PersonaMapper {
    PersonaDTO toDTO(Persona entity);

    Persona toEntity(PersonaDTO dto);

    List<PersonaDTO> toDTO(List<Persona> listEntity);

    List<Persona> toEntity(List<PersonaDTO> listDTOs);
}
