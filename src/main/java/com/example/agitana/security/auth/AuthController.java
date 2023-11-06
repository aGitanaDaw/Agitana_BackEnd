package com.example.agitana.security.auth;

import com.example.agitana.dto.LoginDTO;
import com.example.agitana.dto.UsuarioDTO;
import com.example.agitana.models.Usuario;
import com.example.agitana.security.service.AuthenticationService;
import com.example.agitana.security.service.JwtService;
import com.example.agitana.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private JwtService jwtService;


    @PostMapping("/register")
    public AuthenticationResponseDTO register(@RequestBody UsuarioDTO usuarioDTO){
        Usuario usuarioNuevo = usuarioService.save(usuarioDTO);
        String token = jwtService.generateToken(usuarioNuevo.getPersona());

        return AuthenticationResponseDTO
                .builder()
                .token(token)
                .message("Usuario creado correctamente")
                .build();
    }

    @PostMapping("/login")
    public AuthenticationResponseDTO register(@RequestBody LoginDTO loginDTO){
        if(authenticationService.verifyPassword(loginDTO)){
            return authenticationService.login(loginDTO);
        }else{
            return AuthenticationResponseDTO.builder().message("Invalid credentials").build();
        }
    }
}
