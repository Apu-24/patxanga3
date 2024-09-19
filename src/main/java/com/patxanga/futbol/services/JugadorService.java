package com.patxanga.futbol.services;

import com.patxanga.futbol.models.Jugador;
import com.patxanga.futbol.models.Partido;
import com.patxanga.futbol.models.Usuario;
import com.patxanga.futbol.repositories.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    // Obtener todos los jugadores
    public List<Jugador> getAllJugadores() {
        return jugadorRepository.findAll();
    }

    // Guardar un nuevo jugador
    public Jugador saveJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    // Obtener un jugador por su ID
    public Optional<Jugador> getJugadorById(Long id) {
        return jugadorRepository.findById(id);
    }

    // Obtener jugadores por usuario
    public List<Jugador> getJugadoresByUsuario(Usuario usuario) {
        return jugadorRepository.findByUsuario(usuario);
    }

    // Obtener jugadores por partido
    public List<Jugador> getJugadoresByPartido(Partido partido) {
        return jugadorRepository.findByPartido(partido);
    }

    // Eliminar un jugador por ID
    public void deleteJugador(Long id) {
        jugadorRepository.deleteById(id);
    }
}
