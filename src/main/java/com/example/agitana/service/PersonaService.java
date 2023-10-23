package com.example.agitana.service;

import com.example.agitana.Repository.PersonaRepository;
import com.example.agitana.converter.PersonaMapper;
import com.example.agitana.dto.PersonaDTO;
import com.example.agitana.models.Persona;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class PersonaService {

    private PersonaRepository personaRepository;

    @Autowired
    private PersonaMapper personaMapper;
    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }
    public List<PersonaDTO> listarPersona() {
        return personaMapper.toDTO(personaRepository.findAll());
    }

    public Persona getById(Integer id){
        return personaRepository.findById(id).orElse(null);
    }



    public PersonaDTO crearPersona(PersonaDTO personaDTO){
        return personaMapper.toDTO(personaRepository.save(personaMapper.toEntity(personaDTO)));
    }
    public Persona modificarPersona(PersonaDTO personaDTO){
        Persona persona = personaRepository.findById(personaDTO.getId()).orElse(null);

        if(persona == null){
            return null;
        }else{
            persona.setNombre(personaDTO.getNombre());
            persona.setApellido_Primero(personaDTO.getApellido_Primero());
            persona.setApellido_Segundo(personaDTO.getApellido_Segundo());
            persona.setTelefono(personaDTO.getTelefono());
            persona.setDni(personaDTO.getDni());
            persona.setTipoPersona(personaDTO.getTipoPersona());
            Persona personaModificado = personaRepository.save(persona);
            return personaModificado;
        }

    }
    public String eliminarPersona(PersonaDTO personaDTO){
        Persona personaEliminar = personaRepository.findById(personaDTO.getId()).orElse(null);
        if(personaEliminar != null){
            personaRepository.delete(personaEliminar);
            return "Datos eliminados correctamente";
        }else{
            return "No se ha podido eliminar su producto";
        }
    }
}
