package com.patxanga.futbol.repositories;

import com.patxanga.futbol.models.Jugador;
import com.patxanga.futbol.models.Partido;
import com.patxanga.futbol.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    // Encuentra jugadores por usuario
    List<Jugador> findByUsuario(Usuario usuario);

    // Encuentra jugadores por partido
    List<Jugador> findByPartido(Partido partido);
}
