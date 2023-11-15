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
    @Autowired
    protected CategoriaService categoriaService;
    @Autowired
    protected CategoriaMapper categoriaMapper;


    @Mapping(source = "persona", target = "personaDTO", qualifiedByName = "conversorPersonaDTO")
    @Mapping(source = "categoria", target = "categoriaDTO", qualifiedByName = "conversorCategoriaDTO")
    public abstract DonacionDTO toDTO(Donacion entity);

    @Mapping(source = "personaDTO", target = "persona", qualifiedByName = "conversorPersonaEntity")
    @Mapping(source = "categoriaDTO", target = "categoria", qualifiedByName = "conversorCategoriaEntity")
    public abstract Donacion toEntity(DonacionDTO dto);

    public abstract List<DonacionDTO> toDTO(List<Donacion> listEntity);

    public abstract List<Donacion> toEntity(List<DonacionDTO> listDTOs);

    @Named(value = "conversorPersonaEntity")
    Persona conversor(PersonaDTO dto){ return personaService.getById(dto.getId()); }

    @Named(value = "conversorPersonaDTO")
    PersonaDTO convertir(Persona entity){
        return personaMapper.toDTO(entity);
    }

    @Named(value = "conversorCategoriaEntity")
    Categoria conversor(CategoriaDTO dto){
        return categoriaService.getById(dto.getId());
    }

    @Named(value = "conversorCategoriaDTO")
    CategoriaDTO convertir(Categoria entity){
        return categoriaMapper.toDTO(entity);
    }
}
