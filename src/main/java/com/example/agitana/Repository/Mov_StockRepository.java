package com.example.agitana.Repository;

import com.example.agitana.models.Mov_Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Mov_StockRepository extends JpaRepository<Mov_Stock,Integer> {
}