package com.example.agitana.service;

import com.example.agitana.Repository.SolicitudesRepository;
import com.example.agitana.models.Solicitudes;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Getter
public class SolicitudesService {

    private final SolicitudesRepository solicitudesRepository;

    @Autowired
    public SolicitudesService(SolicitudesRepository solicitudesRepository) {
        this.solicitudesRepository = solicitudesRepository;
    }

    //public List<Solicitudes> listarSolicitudes() {
    //    return SolicitudesRepository.findAll();
  //  }
}
