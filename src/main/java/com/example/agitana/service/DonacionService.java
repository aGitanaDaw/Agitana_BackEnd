package com.example.agitana.service;

import com.example.agitana.Repository.CategoriaRepository;
import com.example.agitana.Repository.DonacionRepository;
import com.example.agitana.Repository.PersonaRepository;
import com.example.agitana.Repository.TipoRepository;
import com.example.agitana.converter.DonacionMapper;
import com.example.agitana.dto.DonacionDTO;
import com.example.agitana.dto.SolicitudesDTO;
import com.example.agitana.models.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Getter
public class DonacionService {
    @Autowired
    private final DonacionRepository donacionRepository;
    @Autowired
    private DonacionMapper donacionMapper;
    @Autowired
    private TipoRepository tipoRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public DonacionService(DonacionRepository Donacionrepository, DonacionRepository donacionrepository) {
        this.donacionRepository = donacionrepository;
    }
    public List<DonacionDTO> listarDonacion() {
        return donacionMapper.toDTO(donacionRepository.findAll());
    }

    public DonacionDTO listarDonacionPorId(Integer id) {
        Optional<Donacion> donacionOptional = donacionRepository.findById(id);

        if (donacionOptional.isPresent()) {
            Donacion donacion = donacionOptional.get();
            return donacionMapper.toDTO(donacion);
        } else {
            return null;
        }
    }

    public Donacion getById(Integer id){
        return donacionRepository.findById(id).orElse(null);
    }
    public DonacionDTO crearDonacion(DonacionDTO donacionDTO){
        return donacionMapper.toDTO(donacionRepository.save(donacionMapper.toEntity(donacionDTO)));
    }
    public Donacion modificarDonacion(DonacionDTO donacionDTO){
        Donacion donacion = donacionRepository.findById(donacionDTO.getId()).orElse(null);

        if(donacion == null){
            return null;
        }else{

            Categoria categoria = categoriaRepository.findById(donacionDTO.getCategoriaDTO().getId()).orElse(null);
            Persona persona = personaRepository.findById(donacionDTO.getPersonaDTO().getId()).orElse(null);


            donacion.setDescripcion_producto(donacionDTO.getDescripcion_producto());
            donacion.setCategoria(categoria);
            donacion.setPersona(persona);
            donacion.setEstado(donacionDTO.getEstado());
            Donacion donacionModificado = donacionRepository.save(donacion);
            return donacionModificado;
        }

    }
    public String eliminarDonacion(DonacionDTO donacionDTO){
        Donacion donacionEliminar = donacionRepository.findById(donacionDTO.getId()).orElse(null);
        if(donacionEliminar != null){
            donacionRepository.delete(donacionEliminar);
            return "Datos eliminados correctamente";
        }else{
            return "No se ha podido eliminar su producto";
        }
    }


}
