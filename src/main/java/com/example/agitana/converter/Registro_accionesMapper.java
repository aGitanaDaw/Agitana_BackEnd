package com.example.agitana.converter;

import com.example.agitana.dto.*;
import com.example.agitana.models.*;
import com.example.agitana.service.DonacionService;
import com.example.agitana.service.SolicitudesService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class Registro_accionesMapper {
    @Autowired
    SolicitudesService solicitudesService;
    @Autowired
    DonacionService donacionService;
    DonacionMapper donacionMapper = Mappers.getMapper(DonacionMapper.class);
    SolicitudesMapper solicitudesMapper = Mappers.getMapper(SolicitudesMapper.class);
    @Mapping(source = "solicitudes", target = "solicitudesDTO", qualifiedByName = "conversorSolicitudesDTO")
    @Mapping(source = "donacion", target = "donacionDTO", qualifiedByName = "conversorDonacionDTO")
    public abstract Registro_accionesDTO toDTO(Registro_acciones entity);

    @Mapping(source = "solicitudesDTO", target = "solicitudes", qualifiedByName = "conversorSolicitudesEntity")
    @Mapping(source = "donacionDTO", target = "donacion", qualifiedByName = "conversorDonacionEntity")
    public abstract Registro_acciones toEntity(Registro_accionesDTO dto);

    public abstract List<Registro_accionesDTO> toDTO(List<Registro_acciones> listEntity);

    public abstract List<Registro_acciones> toEntity(List<Registro_accionesDTO> listDTOs);

    @Named(value = "conversorSolicitudesEntity")
    Solicitudes conversor(SolicitudesDTO dto){
        return solicitudesService.getById(dto.getId());
    }

    @Named(value = "conversorSolicitudesDTO")
    SolicitudesDTO convertir(Solicitudes entity){
        return solicitudesMapper.toDTO(entity);
    }
    @Named(value = "conversorDonacionEntity")
    Donacion conversor(DonacionDTO dto){
        return donacionService.getById(dto.getId());
    }

    @Named(value = "conversorDonacionDTO")
    DonacionDTO convertir(Donacion entity){
        return donacionMapper.toDTO(entity);
    }
}
