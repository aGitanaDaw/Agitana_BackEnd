package com.example.agitana.service;

import com.example.agitana.Repository.AlmacenRepository;
import com.example.agitana.converter.AlmacenMapper;
import com.example.agitana.dto.AlmacenDTO;
import com.example.agitana.models.Almacen;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class AlmacenService {
    private AlmacenRepository almacenRepository;

    @Autowired
    private AlmacenMapper almacenMapper;
    @Autowired
    public AlmacenService(AlmacenRepository almacenRepository) {

        this.almacenRepository = almacenRepository;
    }
    public List<AlmacenDTO> listarAlmacen() {
        return almacenMapper.toDTO(almacenRepository.findAll());
    }
    public Almacen getById(Integer id){
        return almacenRepository.findById(id).orElse(null);
    }
    private AlmacenDTO convertir(Almacen almacen){
        AlmacenDTO almacenDTO = new AlmacenDTO();
        almacenDTO.setId(almacen.getId());
        almacenDTO.setNombre(almacen.getNombre());
        almacenDTO.setFecha_entrada(almacen.getFecha_entrada());

        return almacenDTO;
    }
}
