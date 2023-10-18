package com.example.agitana.service;


import com.example.agitana.Repository.CategoriaRepository;
import com.example.agitana.converter.CategoriaMapper;
import com.example.agitana.dto.CategoriaDTO;
import com.example.agitana.models.Categoria;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;
    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {

        this.categoriaRepository = categoriaRepository;
    }
    public List<CategoriaDTO> listarCategoria() {
        return categoriaMapper.toDTO(categoriaRepository.findAll());
    }

    public Categoria getById(Integer id){
        return categoriaRepository.findById(id).orElse(null);
    }


    private CategoriaDTO convertir(Categoria categoria){
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setNombre(categoria.getNombre());
        categoriaDTO.setDescripcion(categoria.getDescripcion());

        return  categoriaDTO;
}

}