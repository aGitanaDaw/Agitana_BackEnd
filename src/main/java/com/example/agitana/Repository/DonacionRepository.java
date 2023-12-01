package com.example.agitana.Repository;

import com.example.agitana.models.Donacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonacionRepository extends JpaRepository<Donacion,Integer> {

    @Query(value = "select c.* from {h-schema} donacion c where c.id_persona = :id " , nativeQuery = true)
    List<Donacion> buscarPorid(Integer id);

}
