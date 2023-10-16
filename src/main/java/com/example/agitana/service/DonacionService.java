package com.example.agitana.service;

import com.example.agitana.Repository.DonacionRepository;
import com.example.agitana.models.Donacion;
import com.example.agitana.models.Producto;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class DonacionService {

    private final DonacionRepository donacionRepository;

    @Autowired
    public DonacionService(DonacionRepository donacionRepository) {
        this.donacionRepository = donacionRepository;
    }

    public List<Donacion> listarDonacion() {
        return donacionRepository.findAll();
    }




}
