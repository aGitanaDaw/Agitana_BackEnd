package com.example.agitana.converter;

import com.example.agitana.dto.PersonaDTO;
import com.example.agitana.models.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-20T19:54:50+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class PersonaMapperImpl implements PersonaMapper {

    @Override
    public PersonaDTO toDTO(Persona entity) {
        if ( entity == null ) {
            return null;
        }

        PersonaDTO personaDTO = new PersonaDTO();

        personaDTO.setId( entity.getId() );
        personaDTO.setNombre( entity.getNombre() );
        personaDTO.setApellido_Primero( entity.getApellido_Primero() );
        personaDTO.setApellido_Segundo( entity.getApellido_Segundo() );
        personaDTO.setTelefono( entity.getTelefono() );
        personaDTO.setDni( entity.getDni() );
        personaDTO.setTipoPersona( entity.getTipoPersona() );

        return personaDTO;
    }

    @Override
    public Persona toEntity(PersonaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Persona persona = new Persona();

        persona.setId( dto.getId() );
        persona.setNombre( dto.getNombre() );
        persona.setApellido_Primero( dto.getApellido_Primero() );
        persona.setApellido_Segundo( dto.getApellido_Segundo() );
        persona.setTelefono( dto.getTelefono() );
        persona.setDni( dto.getDni() );
        persona.setTipoPersona( dto.getTipoPersona() );

        return persona;
    }

    @Override
    public List<PersonaDTO> toDTO(List<Persona> listEntity) {
        if ( listEntity == null ) {
            return null;
        }

        List<PersonaDTO> list = new ArrayList<PersonaDTO>( listEntity.size() );
        for ( Persona persona : listEntity ) {
            list.add( toDTO( persona ) );
        }

        return list;
    }

    @Override
    public List<Persona> toEntity(List<PersonaDTO> listDTOs) {
        if ( listDTOs == null ) {
            return null;
        }

        List<Persona> list = new ArrayList<Persona>( listDTOs.size() );
        for ( PersonaDTO personaDTO : listDTOs ) {
            list.add( toEntity( personaDTO ) );
        }

        return list;
    }
}
