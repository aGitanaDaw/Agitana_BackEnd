package com.example.agitana.service;

import com.example.agitana.Repository.DonacionRepository;
import com.example.agitana.Repository.Registro_accionesRepository;
import com.example.agitana.Repository.SolicitudesRepository;
import com.example.agitana.converter.Registro_accionesMapper;
import com.example.agitana.dto.CategoriaDTO;
import com.example.agitana.dto.DonacionDTO;
import com.example.agitana.dto.Registro_accionesDTO;
import com.example.agitana.dto.SolicitudesDTO;
import com.example.agitana.models.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Getter
public class Registro_accionesService {
@Autowired
private Registro_accionesMapper registro_accionesMapper;
@Autowired
private DonacionRepository donacionRepository;
@Autowired
private SolicitudesRepository solicitudesRepository;
@Autowired
private Registro_accionesRepository registro_accionesRepository;
    public List<Registro_accionesDTO> listarRegistro_acciones() {
        return registro_accionesMapper.toDTO(registro_accionesRepository.findAll());
    }
    public Registro_acciones getById(Integer id){
        return registro_accionesRepository.findById(id).orElse(null);
    }
    public Registro_accionesDTO crearRegistro_acciones(Registro_accionesDTO registro_accionesDTO){
        return registro_accionesMapper.toDTO(registro_accionesRepository.save(registro_accionesMapper.toEntity(registro_accionesDTO)));
    }
    public Registro_acciones modificarRegistro_acciones(Registro_accionesDTO registro_accionesDTO){
        Registro_acciones registro_acciones = registro_accionesRepository.findById(registro_accionesDTO.getId()).orElse(null);

        if(registro_acciones == null){
            return null;
        }else{

            Donacion donacion = donacionRepository.findById(registro_accionesDTO.getDonacionDTO().getId()).orElse(null);
            Solicitudes solicitudes = solicitudesRepository.findById(registro_accionesDTO.getSolicitudesDTO().getId()).orElse(null);



            registro_acciones.setFecha(registro_acciones.getFecha());
            Registro_acciones registro_accionesmodificado = registro_accionesRepository.save(registro_acciones);
            return registro_accionesmodificado;

        }

    }
    public String eliminarRegistro_acciones(Registro_accionesDTO registro_accionesDTO) {
        Registro_acciones registro_accionesEliminar = registro_accionesRepository.findById(registro_accionesDTO.getId()).orElse(null);
        if ( registro_accionesEliminar!= null) {
            registro_accionesRepository.delete(registro_accionesEliminar);
            return "Datos eliminados correctamente";
        } else {
            return "No se ha podido eliminar el producto";
        }
    }
}
