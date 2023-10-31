package com.example.agitana.service;

import com.example.agitana.Repository.UsuarioRepository;
import com.example.agitana.converter.UsuarioMapper;
import com.example.agitana.dto.UsuarioDTO;
import com.example.agitana.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Usuario loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findTopByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }

    public UsuarioDTO getByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findTopByUsername(username).orElse(null);

        if (usuario != null) {
            return usuarioMapper.toDTO(usuario);
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

    }

    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        return usuarioMapper.toDTO(usuarioRepository.save(usuarioMapper.toEntity(usuarioDTO)));
    }

    public Boolean existByCredentials(String username, String password) {
        Usuario usuario = usuarioRepository.findTopByUsername(username).orElse(null);
        return usuario != null && passwordEncoder.matches(password, usuario.getPassword());
    }
    public List<UsuarioDTO> listarUsuario() {
        return usuarioMapper.toDTO(usuarioRepository.findAll());
    }
    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO){
        return usuarioMapper.toDTO(usuarioRepository.save(usuarioMapper.toEntity(usuarioDTO)));
    }
    public Usuario modificarUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioRepository.findById(usuarioDTO.getId()).orElse(null);

        if(usuario == null){
            return null;
        }else{
            usuario.setUsername(usuarioDTO.getUsername());
            usuario.setPassword(usuarioDTO.getPassword());
            usuario.setTipoRol(usuarioDTO.getTipoRol());
            Usuario usuarioModificado = usuarioRepository.save(usuario);
            return usuarioModificado;

        }

    }
    public String eliminarUsuario(UsuarioDTO usuarioDTO){
        Usuario usuarioEliminar = usuarioRepository.findById(usuarioDTO.getId()).orElse(null);
        if(usuarioEliminar != null){
            usuarioRepository.delete(usuarioEliminar);
            return "Datos eliminados correctamente";
        }else{
            return "No se ha podido eliminar su producto";
        }
    }
}
