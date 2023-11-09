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
    public CategoriaDTO createCategoria(CategoriaDTO categoriaDTO){
        return categoriaMapper.toDTO(categoriaRepository.save(categoriaMapper.toEntity(categoriaDTO)));
    }
    public Categoria modificarCategoria(CategoriaDTO categoriaDTO){
        Categoria categoria = categoriaRepository.findById(categoriaDTO.getId()).orElse(null);

        if(categoria == null){
            return null;
        }else{
            categoria.setNombre(categoriaDTO.getNombre());
            categoria.setDescripcion(categoriaDTO.getDescripcion());
            Categoria categoriaModificado = categoriaRepository.save(categoria);
            return categoriaModificado;

        }

    }
    public String eliminarCategoria(CategoriaDTO categoriaDTO){
        Categoria categoriaEliminar = categoriaRepository.findById(categoriaDTO.getId()).orElse(null);
        if(categoriaEliminar != null){
            categoriaRepository.delete(categoriaEliminar);
            return "Datos eliminados correctamente";
        }else{
            return "No se ha podido eliminar su producto";
        }
    }

}