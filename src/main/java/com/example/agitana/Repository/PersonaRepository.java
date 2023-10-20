package com.example.agitana.Repository;

import com.example.agitana.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Integer> {
}
