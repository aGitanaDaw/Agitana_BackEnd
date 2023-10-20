package com.example.agitana.service;

import com.example.agitana.Repository.PersonaRepository;
import com.example.agitana.Repository.TipoRepository;
import com.example.agitana.converter.PersonaMapper;
import com.example.agitana.converter.TipoMapper;
import com.example.agitana.dto.PersonaDTO;
import com.example.agitana.dto.TipoDTO;
import com.example.agitana.models.Persona;
import com.example.agitana.models.Tipo;
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


    private PersonaDTO convertir(Persona persona){
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setId(persona.getId());
        personaDTO.setNombre(persona.getNombre());

        return  personaDTO;
    }
}
