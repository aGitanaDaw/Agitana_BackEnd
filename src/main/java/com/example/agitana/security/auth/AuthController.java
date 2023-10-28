package com.example.agitana.security.auth;

import com.example.agitana.dto.LoginDTO;
import com.example.agitana.dto.UsuarioDTO;
import com.example.agitana.security.service.AuthenticationService;
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


    @PostMapping("/register")
    public AuthenticationResponseDTO register(@RequestBody UsuarioDTO usuarioDTO){
        return  authenticationService.register(usuarioDTO);
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
