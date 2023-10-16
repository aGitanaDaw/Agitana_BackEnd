package com.example.agitana.Repository;

import com.example.agitana.models.productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<productos,Integer> {
}
