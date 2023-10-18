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
}
