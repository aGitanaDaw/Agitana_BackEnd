package com.example.agitana.converter;


import com.example.agitana.dto.AlmacenDTO;
import com.example.agitana.dto.CategoriaDTO;
import com.example.agitana.dto.PersonaDTO;
import com.example.agitana.dto.SolicitudesDTO;
import com.example.agitana.models.Almacen;
import com.example.agitana.models.Categoria;
import com.example.agitana.models.Persona;
import com.example.agitana.models.Solicitudes;
import com.example.agitana.service.PersonaService;
import com.example.agitana.service.SolicitudesService;
import com.example.agitana.service.CategoriaService;
import com.example.agitana.service.AlmacenService;
//import com.example.agitana.dto.PersonaService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class SolicitudesMapper {

    @Autowired
    protected CategoriaService categoriaService;
    @Autowired
    protected AlmacenService almacenService;
    @Autowired
    protected PersonaService personaService;


    AlmacenMapper almacenMapper = Mappers.getMapper(AlmacenMapper.class);
    PersonaMapper personaMapper = Mappers.getMapper(PersonaMapper.class);
    CategoriaMapper categoriaMapper = Mappers.getMapper(CategoriaMapper.class);

    @Mapping(source = "almacen", target = "almacenDTO", qualifiedByName = "conversorAlmacenDTO")
    @Mapping(source = "persona", target = "personaDTO", qualifiedByName = "conversorPersonaDTO")
    @Mapping(source = "categoria", target = "categoriaDTO", qualifiedByName = "conversorCategoriaDTO")
    public abstract SolicitudesDTO toDTO(Solicitudes entity);


    @Mapping(source = "almacenDTO", target = "almacen", qualifiedByName = "conversorAlmacenEntity")
    @Mapping(source = "personaDTO", target = "persona", qualifiedByName = "conversorPersonaEntity")
    @Mapping(source = "categoriaDTO", target = "categoria", qualifiedByName = "conversorCategoriaEntity")
    public abstract Solicitudes toEntity(SolicitudesDTO dto);


    public  abstract List<SolicitudesDTO> toDTO(List<Solicitudes> entity);
    public abstract List<Solicitudes> toEntity(List<SolicitudesDTO> dto);



    @Named(value = "conversorAlmacenEntity")
    Almacen conversor(AlmacenDTO dto){
        return almacenService.getById(dto.getId());
    }

    @Named(value = "conversorAlmacenDTO")
    AlmacenDTO conversor(Almacen entity){
        return almacenMapper.toDTO(entity);
    }

    @Named(value = "conversorPersonaEntity")
    Persona conversor(PersonaDTO dto){
        return personaService.getById(dto.getId());
    }

    @Named(value = "conversorPersonaDTO")
    PersonaDTO conversor(Persona entity){
        return personaMapper.toDTO(entity);
    }

    @Named(value = "conversorCategoriaEntity")
    Categoria conversor(CategoriaDTO dto){
        return categoriaService.getById(dto.getId());
    }

    @Named(value = "conversorCategoriaDTO")
    CategoriaDTO conversor(Categoria entity){
        return categoriaMapper.toDTO(entity);
    }

}



