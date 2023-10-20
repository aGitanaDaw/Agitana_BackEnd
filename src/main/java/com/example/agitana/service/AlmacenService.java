package com.example.agitana.service;

import com.example.agitana.Repository.AlmacenRepository;
import com.example.agitana.Repository.CategoriaRepository;
import com.example.agitana.converter.AlmacenMapper;
import com.example.agitana.dto.AlmacenDTO;
import com.example.agitana.models.Almacen;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Getter
public class AlmacenService {
    @Autowired
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
    public AlmacenDTO createAlmacen(AlmacenDTO almacenDTO){
        return almacenMapper.toDTO(almacenRepository.save(almacenMapper.toEntity(almacenDTO)));
    }
    public Almacen modificarAlmacen(AlmacenDTO almacenDTO){
        Almacen almacen = almacenRepository.findById(almacenDTO.getId()).orElse(null);

        if(almacen == null){
            return null;
        }else{
            almacen.setNombre(almacenDTO.getNombre());
            Almacen almacenModificado = almacenRepository.save(almacen);
            return almacenModificado;

        }

    }
    public String eliminarAlmacen(AlmacenDTO almacenDTO){
        Almacen almacenEliminar = almacenRepository.findById(almacenDTO.getId()).orElse(null);
        if(almacenEliminar != null){
            almacenRepository.delete(almacenEliminar);
            return "Datos eliminados correctamente";
        }else{
            return "No se ha podido eliminar su producto";
        }
    }
}
