package com.example.agitana.controller;

import com.example.agitana.dto.UsuarioDTO;
import com.example.agitana.service.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
@SecurityRequirement(name = "Bearer Authentication")
public class ClienteController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/all")
    public List<UsuarioDTO> obtenerTodos(){
        return usuarioService.listarUsuario();
    }

    @GetMapping("/find")
    public List<UsuarioDTO> buscarPorNombre(@RequestParam String username){
        return usuarioService.buscarPorNombre(username);
    }

    @PostMapping("/crear")
    public UsuarioDTO crearCliente(@Valid @RequestBody UsuarioDTO usuarioDTO){
        return null;
    }

}
