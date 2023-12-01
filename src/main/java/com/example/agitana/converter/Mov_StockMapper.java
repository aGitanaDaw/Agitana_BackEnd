package com.example.agitana.converter;


import com.example.agitana.dto.DonacionDTO;
import com.example.agitana.dto.Mov_StockDTO;
import com.example.agitana.dto.SolicitudesDTO;
import com.example.agitana.dto.StockDTO;
import com.example.agitana.models.Donacion;
import com.example.agitana.models.Mov_Stock;
import com.example.agitana.models.Solicitudes;
import com.example.agitana.models.Stock;
import com.example.agitana.service.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class  Mov_StockMapper {
    @Autowired
    protected SolicitudesService solicitudesService;

    @Autowired
    protected DonacionService donacionService;

    @Autowired
    protected StockService stockService;

    SolicitudesMapper solicitudesMapper = Mappers.getMapper(SolicitudesMapper.class);
    DonacionMapper donacionMapper = Mappers.getMapper(DonacionMapper.class);

    StockMapper stockMapper = Mappers.getMapper(StockMapper.class);

    @Mapping(source = "solicitud", target = "solicitudesDTO", qualifiedByName = "conversorSolicitudesDTO")
    @Mapping(source = "donacion", target = "donacionDTO", qualifiedByName = "conversorDonacionDTO")
    @Mapping(source = "stock", target = "stockDTO", qualifiedByName = "conversorStockDTO")
    public abstract Mov_StockDTO toDTO(Mov_Stock entity);

    @Mapping(source = "solicitudesDTO", target = "solicitud", qualifiedByName = "conversorSolicitudesEntity")
    @Mapping(source = "donacionDTO", target = "donacion", qualifiedByName = "conversorDonacionEntity")
    @Mapping(source = "stockDTO", target = "stock", qualifiedByName = "conversorStockEntity")
    public abstract Mov_Stock toEntity(Mov_StockDTO dto);

    public abstract List<Mov_StockDTO> toDTO(List<Mov_Stock> listEntity);

    public abstract List<Mov_Stock> toEntity(List<Mov_StockDTO> listDTOs);


    @Named(value = "conversorSolicitudesDTO")
    SolicitudesDTO convertir(Solicitudes entity){
        return solicitudesMapper.toDTO(entity);
    }
    @Named(value = "conversorSolicitudesEntity")
    Solicitudes conversor(SolicitudesDTO dto){
        return solicitudesService.getById(dto.getId());
    }

    @Named(value = "conversorDonacionDTO")
    DonacionDTO convertir(Donacion entity){
        return donacionMapper.toDTO(entity);
    }

    @Named(value = "conversorDonacionEntity")
    Donacion conversor(DonacionDTO dto){
        return donacionService.getById(dto.getId());
    }

    @Named(value = "conversorStockDTO")
    StockDTO convertir(Stock entity){
        return stockMapper.toDTO(entity);
    }

    @Named(value = "conversorStockEntity")
    Stock conversor(StockDTO dto){
        return stockService.getById(dto.getId());
    }


}
