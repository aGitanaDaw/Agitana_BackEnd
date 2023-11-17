package com.example.agitana.Repository;

import com.example.agitana.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findTopByUsername(String username);

    Boolean existsByUsernameAndPassword(String username, String password);
    @Query(value = "select c.* from {h-schema} usuario c where c.username like %:username% " , nativeQuery = true)
    List<Usuario> buscarPorNombre(String username);
}