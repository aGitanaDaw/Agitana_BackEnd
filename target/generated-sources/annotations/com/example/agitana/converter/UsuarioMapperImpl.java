package com.example.agitana.converter;

import com.example.agitana.dto.UsuarioDTO;
import com.example.agitana.models.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-23T20:37:38+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDTO toDTO(Usuario entity) {
        if ( entity == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId( entity.getId() );
        usuarioDTO.setUsername( entity.getUsername() );
        usuarioDTO.setPassword( entity.getPassword() );
        usuarioDTO.setTipoRol( entity.getTipoRol() );

        return usuarioDTO;
    }

    @Override
    public Usuario toEntity(UsuarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( dto.getId() );
        usuario.setUsername( dto.getUsername() );
        usuario.setPassword( dto.getPassword() );
        usuario.setTipoRol( dto.getTipoRol() );

        return usuario;
    }

    @Override
    public List<UsuarioDTO> toDTO(List<Usuario> listEntity) {
        if ( listEntity == null ) {
            return null;
        }

        List<UsuarioDTO> list = new ArrayList<UsuarioDTO>( listEntity.size() );
        for ( Usuario usuario : listEntity ) {
            list.add( toDTO( usuario ) );
        }

        return list;
    }

    @Override
    public List<Usuario> toEntity(List<UsuarioDTO> listDTOs) {
        if ( listDTOs == null ) {
            return null;
        }

        List<Usuario> list = new ArrayList<Usuario>( listDTOs.size() );
        for ( UsuarioDTO usuarioDTO : listDTOs ) {
            list.add( toEntity( usuarioDTO ) );
        }

        return list;
    }
}
