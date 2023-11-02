package com.example.agitana.security.service;



import com.example.agitana.converter.UsuarioMapper;
import com.example.agitana.dto.LoginDTO;
import com.example.agitana.dto.UsuarioDTO;
import com.example.agitana.security.auth.AuthenticationResponseDTO;
import com.example.agitana.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final UsuarioService usuarioService;

    private final UsuarioMapper usuarioMapper;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    public AuthenticationResponseDTO register(UsuarioDTO usuarioDTO){
        usuarioDTO.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));
        UsuarioDTO dto = usuarioService.save(usuarioDTO);
        String token = jwtService.generateToken(usuarioMapper.toEntity(dto));
        return AuthenticationResponseDTO
                .builder()
                .token(token)
                .build();
    }

    public AuthenticationResponseDTO login(LoginDTO loginDTO){
        UsuarioDTO user = usuarioService.getByUsername(loginDTO.getUsername());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getUsername(),
                        loginDTO.getPassword(),
                        List.of(new SimpleGrantedAuthority(user.getTipoRol().name()))
                )
        );
        String token = jwtService.generateToken(usuarioMapper.toEntity(user));

                if(user.getTipoRol().name()=="ADMIN"){
                    return AuthenticationResponseDTO
                            .builder()
                            .token(token)
                            .message("Login success")
                            .rol(user.getTipoRol().name())

                            .build();

                }else{
                    return AuthenticationResponseDTO
                            .builder()
                            .token(token)
                            .message("Login success")
                            .rol(user.getTipoRol().name())
                            .tipo(String.valueOf(user.getPersonaDTO().getTipoPersona()))
                            .build();
                }


    }

    public boolean verifyPassword(LoginDTO loginDTO){
        return usuarioService.existByCredentials(loginDTO.getUsername(),loginDTO.getPassword());

    }
}
