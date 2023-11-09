package com.example.agitana.service;


import com.example.agitana.Repository.TipoRepository;
import com.example.agitana.converter.TipoMapper;
import com.example.agitana.dto.TipoDTO;
import com.example.agitana.models.Tipo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class TipoService {

    private TipoRepository tipoRepository;

    @Autowired
    private TipoMapper tipoMapper;
    @Autowired
    public TipoService(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }
    public List<TipoDTO> listarTipo() {
        return tipoMapper.toDTO(tipoRepository.findAll());
    }

    public Tipo getById(Integer id){
        return tipoRepository.findById(id).orElse(null);
    }


    private TipoDTO convertir(Tipo tipo){
        TipoDTO tipoDTO = new TipoDTO();
        tipoDTO.setId(tipo.getId());
        tipoDTO.setNombre(tipo.getNombre());

        return  tipoDTO;
    }

    public TipoDTO createTipo(TipoDTO tipoDTO){
        return tipoMapper.toDTO(tipoRepository.save(tipoMapper.toEntity(tipoDTO)));
    }

    public Tipo modificarTipo(TipoDTO tipoDTO){
        Tipo tipo = tipoRepository.findById(tipoDTO.getId()).orElse(null);

        if(tipo == null){
            return null;
        }else{
            tipo.setNombre(tipoDTO.getNombre());
            Tipo tipomodificado = tipoRepository.save(tipo);
            return tipomodificado;

        }

    }
    public String eliminarTipo(TipoDTO tipoDTO){
        Tipo tipoEliminar = tipoRepository.findById(tipoDTO.getId()).orElse(null);
        if(tipoEliminar != null){
            tipoRepository.delete(tipoEliminar);
            return "Datos eliminados correctamente";
        }else{
            return "No se ha podido eliminar su producto";
        }
    }
}
