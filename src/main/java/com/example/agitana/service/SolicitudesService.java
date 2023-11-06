package com.example.agitana.service;

import com.example.agitana.Repository.*;
import com.example.agitana.converter.SolicitudesMapper;
import com.example.agitana.dto.AlmacenDTO;
import com.example.agitana.dto.SolicitudesDTO;
import com.example.agitana.models.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Getter
public class SolicitudesService {

    @Autowired
    private  SolicitudesRepository solicitudesRepository;
    @Autowired
    private  AlmacenRepository almacenRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private TipoRepository tipoRepository;
    @Autowired
    private  SolicitudesMapper solicitudesMapper;



    public List<SolicitudesDTO> listarSolicitudes() {
        return solicitudesMapper.toDTO(solicitudesRepository.findAll());
    }
    public SolicitudesDTO createSolicitudes(SolicitudesDTO solicitudesDTO){
        return solicitudesMapper.toDTO(solicitudesRepository.save(solicitudesMapper.toEntity(solicitudesDTO)));
    }

    public Solicitudes modificarSolicitudes(SolicitudesDTO solicitudesDTO){
        Solicitudes solicitudes = solicitudesRepository.findById(solicitudesDTO.getId()).orElse(null);

        if(solicitudes == null){
            return null;
        }else{

            Almacen almacen = almacenRepository.findById(solicitudesDTO.getAlmacenDTO().getId()).orElse(null);
            Persona persona = personaRepository.findById(solicitudesDTO.getPersonaDTO().getId()).orElse(null);
            Categoria categoria = categoriaRepository.findById(solicitudesDTO.getCategoriaDTO().getId()).orElse(null);



            solicitudes.setAlmacen(almacen);
            solicitudes.setPersona(persona);
            solicitudes.setCategoria(categoria);
            solicitudes.setTipoSolicitud(solicitudes.getTipoSolicitud());
            Solicitudes solicitudModificada = solicitudesRepository.save(solicitudes);
            return solicitudModificada;

        }

    }
    public String eliminarSolicitud(SolicitudesDTO solicitudesDTO) {
        Solicitudes solicitudesEliminar = solicitudesRepository.findById(solicitudesDTO.getId()).orElse(null);
        if ( solicitudesEliminar!= null) {
            solicitudesRepository.delete(solicitudesEliminar);
            return "Datos eliminados correctamente";
        } else {
            return "No se ha podido eliminar el producto";
        }
    }
}
