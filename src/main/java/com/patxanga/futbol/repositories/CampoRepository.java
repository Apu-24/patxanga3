package com.patxanga.futbol.repositories;

import com.patxanga.futbol.models.Campo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CampoRepository extends JpaRepository<Campo, Long> {

    // Encuentra campos por nombre (puede ser útil para reservas)
    List<Campo> findByNombre(String nombre);

    // Otros métodos personalizados pueden agregarse según necesidades
}
