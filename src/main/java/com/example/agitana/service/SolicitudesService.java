package com.example.agitana.service;

import com.example.agitana.Repository.*;
import com.example.agitana.converter.SolicitudesMapper;
import com.example.agitana.dto.AlmacenDTO;
import com.example.agitana.dto.ProductoDTO;
import com.example.agitana.dto.SolicitudesDTO;
import com.example.agitana.enums.TipoSolicitud;
import com.example.agitana.models.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public SolicitudesDTO listarSolicitudPorId(Integer id) {
        Optional<Solicitudes> solicitudOptional = solicitudesRepository.findById(id);

        if (solicitudOptional.isPresent()) {
            Solicitudes solicitud = solicitudOptional.get();
            return solicitudesMapper.toDTO(solicitud);
        } else {
            return null;
        }
    }
    public SolicitudesDTO createSolicitudes(SolicitudesDTO solicitudesDTO){
        return solicitudesMapper.toDTO(solicitudesRepository.save(solicitudesMapper.toEntity(solicitudesDTO)));
    }

    public Solicitudes modificarSolicitudes(SolicitudesDTO solicitudesDTO){
        Solicitudes solicitudes = solicitudesRepository.findById(solicitudesDTO.getId()).orElse(null);

        Almacen almacen;
        Persona persona;
        Categoria categoria;
        TipoSolicitud estado;
        if(solicitudes == null){
            return null;
        }else{

                if(solicitudesDTO.getAlmacenDTO()==null){
                    almacen = solicitudes.getAlmacen();
                }else{
                    almacen = almacenRepository.findById(solicitudesDTO.getAlmacenDTO().getId()).orElse(null);
                }
             if(solicitudesDTO.getPersonaDTO()==null){
                 persona = solicitudes.getPersona();
             }else{
                 persona = personaRepository.findById(solicitudesDTO.getPersonaDTO().getId()).orElse(null);
             }

             if(solicitudesDTO.getCategoriaDTO()==null){
                 categoria = solicitudes.getCategoria();
             }else{
                 categoria = categoriaRepository.findById(solicitudesDTO.getCategoriaDTO().getId()).orElse(null);
             }
            if(solicitudesDTO.getEstado()==null){
                estado = solicitudes.getEstado();
            }else{
                estado = solicitudesDTO.getEstado();
            }

                solicitudes.setAlmacen(almacen);
                solicitudes.setPersona(persona);
                solicitudes.setCategoria(categoria);
                solicitudes.setEstado(estado);

            solicitudesRepository.save(solicitudes);
            return solicitudes;

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
    public Solicitudes getById(Integer id){
        return solicitudesRepository.findById(id).orElse(null);
    }
}
