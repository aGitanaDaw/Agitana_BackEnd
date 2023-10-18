package com.example.agitana.Repository;

import com.example.agitana.models.Almacen;
import com.example.agitana.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlmacenRepository extends JpaRepository<Almacen,Integer> {
}
