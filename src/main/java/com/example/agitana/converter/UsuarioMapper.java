package com.example.agitana.converter;

import com.example.agitana.dto.PersonaDTO;
import com.example.agitana.dto.UsuarioDTO;
import com.example.agitana.models.Persona;
import com.example.agitana.models.Usuario;
import com.example.agitana.service.PersonaService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UsuarioMapper {

    @Autowired
    protected PersonaService personaService;
    PersonaMapper personaMapper = Mappers.getMapper(PersonaMapper.class);

    @Mapping(source = "persona", target = "personaDTO", qualifiedByName = "conversorpersonaDTO")
    public abstract UsuarioDTO toDTO(Usuario entity);

    @Mapping(source = "personaDTO", target = "persona", qualifiedByName = "conversorpersonaEntity")
    public abstract Usuario toEntity(UsuarioDTO dto);

    public abstract List<UsuarioDTO> toDTO(List<Usuario> listEntity);

    public abstract List<Usuario> toEntity(List<UsuarioDTO> listDTOs);

    @Named(value = "conversorpersonaEntity")
    Persona conversor(PersonaDTO dto){
        return personaService.getById(dto.getId());
    }

    @Named(value = "conversorpersonaDTO")
    PersonaDTO convertir(Persona entity){
        return personaMapper.toDTO(entity);
    }
}
