package com.example.agitana.Repository;

import com.example.agitana.models.Producto;
import com.example.agitana.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock,Integer> {

    @Query(value = "select c.* from {h-schema} stock c where c.id_categoria = :id " , nativeQuery = true)
    List<Stock> buscarporCategoria(Integer id);
}
