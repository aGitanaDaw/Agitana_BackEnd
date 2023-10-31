package com.example.agitana.controller;

import com.example.agitana.dto.UsuarioDTO;
import com.example.agitana.models.Usuario;
import com.example.agitana.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/Admin/Usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    private final UsuarioService usuarioService;


    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(value = "/listar")
    public List<UsuarioDTO> listarUsuario() {
        return usuarioService.listarUsuario();
    }
    @PostMapping(value = "/crear")
    public UsuarioDTO createUsuario(@RequestBody UsuarioDTO dto){

        return usuarioService.createUsuario(dto);
    }
    @PutMapping(value = "/modificar")
    public Usuario modificarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.modificarUsuario(usuarioDTO);
    }
    @DeleteMapping(value = "/eliminar")
    public String eliminarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.eliminarUsuario(usuarioDTO);
    }
}
