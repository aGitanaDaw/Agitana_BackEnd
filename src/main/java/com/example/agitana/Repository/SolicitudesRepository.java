package com.example.agitana.Repository;

import com.example.agitana.models.Solicitudes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudesRepository extends JpaRepository<Solicitudes, Integer> {
}