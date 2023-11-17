package com.example.agitana.controller;

import com.example.agitana.dto.CategoriaDTO;
import com.example.agitana.models.Categoria;
import com.example.agitana.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = {"User/Categoria", "Admin/Categoria"})
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping(value = "/listar")
    public List<CategoriaDTO> listarCategoria() {
        return categoriaService.listarCategoria();
    }
    @PostMapping(value = "/crear")
    public CategoriaDTO createCategoria(@RequestBody CategoriaDTO dto){

        return categoriaService.createCategoria(dto);
    }
    @PutMapping(value = "/modificar")
    public Categoria modificarCategoria(@RequestBody CategoriaDTO categoriaDTO){
        return categoriaService.modificarCategoria(categoriaDTO);
    }
    @DeleteMapping(value = "/eliminar")
    public String eliminarCategoria(@RequestBody CategoriaDTO categoriaDTO){
        return categoriaService.eliminarCategoria(categoriaDTO);
    }

}
