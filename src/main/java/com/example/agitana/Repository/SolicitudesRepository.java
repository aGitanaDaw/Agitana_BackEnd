package com.example.agitana.Repository;

import com.example.agitana.models.Solicitudes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SolicitudesRepository extends JpaRepository<Solicitudes, Integer> {


    @Query(value = "select c.* from {h-schema} solicitudes c where c.id_persona = :id " , nativeQuery = true)
    List<Solicitudes> buscarPorid(Integer id);


}