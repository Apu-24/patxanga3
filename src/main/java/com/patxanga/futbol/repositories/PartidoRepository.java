package com.patxanga.futbol.repositories;

import com.patxanga.futbol.models.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface PartidoRepository extends JpaRepository<Partido, Long> {

    // Encuentra partidos por fecha y hora
    List<Partido> findByFechaHora(LocalDateTime fechaHora);

    // Encuentra partidos por estado (ej: Pendiente, Completado, etc.)
    List<Partido> findByEstado(String estado);
}
