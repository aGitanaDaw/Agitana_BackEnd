package com.example.agitana.Repository;

import com.example.agitana.models.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlmacenRepository extends JpaRepository<Almacen,Integer> {
}
