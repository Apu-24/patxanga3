package com.patxanga.futbol.controllers;

import com.patxanga.futbol.models.Jugador;
import com.patxanga.futbol.models.Partido;
import com.patxanga.futbol.models.Usuario;
import com.patxanga.futbol.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<Jugador> getAllJugadores() {
        return jugadorService.getAllJugadores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> getJugadorById(@PathVariable Long id) {
        Optional<Jugador> jugador = jugadorService.getJugadorById(id);
        return jugador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Jugador createJugador(@RequestBody Jugador jugador) {
        return jugadorService.saveJugador(jugador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJugador(@PathVariable Long id) {
        jugadorService.deleteJugador(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Jugador> getJugadoresByUsuario(@PathVariable Long usuarioId) {
        Usuario usuario = new Usuario(); // Aquí deberías obtener el usuario de alguna manera
        usuario.setId(usuarioId);
        return jugadorService.getJugadoresByUsuario(usuario);
    }

    @GetMapping("/partido/{partidoId}")
    public List<Jugador> getJugadoresByPartido(@PathVariable Long partidoId) {
        Partido partido = new Partido(); // Aquí deberías obtener el partido de alguna manera
        partido.setId(partidoId);
        return jugadorService.getJugadoresByPartido(partido);
    }
}
