package com.example.agitana.converter;


import com.example.agitana.dto.*;
import com.example.agitana.models.*;
import com.example.agitana.service.CategoriaService;
import com.example.agitana.service.PersonaService;
import com.example.agitana.service.TipoService;
import org.aspectj.weaver.patterns.PerObject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DonacionMapper {

    @Autowired
    protected PersonaService personaService;
    @Autowired
    protected TipoMapper tipoMapper;
    @Autowired
    protected TipoService tipoService;
    @Autowired
    protected PersonaMapper personaMapper;


    @Mapping(source = "persona", target = "personaDTO", qualifiedByName = "conversorPersonaDTO")
    @Mapping(source = "tipo", target = "tipoDTO", qualifiedByName = "conversorTipoDTO")
    public abstract DonacionDTO toDTO(Donacion entity);

    @Mapping(source = "personaDTO", target = "persona", qualifiedByName = "conversorPersonaEntity")
    @Mapping(source = "tipoDTO", target = "tipo", qualifiedByName = "conversorTipoEntity")
    public abstract Donacion toEntity(DonacionDTO dto);

    public abstract List<DonacionDTO> toDTO(List<Donacion> listEntity);

    public abstract List<Donacion> toEntity(List<DonacionDTO> listDTOs);

    @Named(value = "conversorPersonaEntity")
    Persona conversor(PersonaDTO dto){ return personaService.getById(dto.getId()); }

    @Named(value = "conversorPersonaDTO")
    PersonaDTO convertir(Persona entity){
        return personaMapper.toDTO(entity);
    }

    @Named(value = "conversorTipoEntity")
    Tipo conversor(TipoDTO dto){
        return tipoService.getById(dto.getId());
    }

    @Named(value = "conversorTipoDTO")
    TipoDTO convertir(Tipo entity){
        return tipoMapper.toDTO(entity);
    }
}
