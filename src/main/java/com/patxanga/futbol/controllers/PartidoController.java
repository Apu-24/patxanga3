package com.patxanga.futbol.controllers;

import com.patxanga.futbol.models.Partido;
import com.patxanga.futbol.services.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    // Mètode per obtenir tots els partits
    @GetMapping
    public List<Partido> listarPartidos() {
        return partidoService.listarPartidos();
    }

    // Mètode per registrar un jugador en un partit
    @PostMapping("/{partidoId}/inscripcion")
    public String registrarJugador(@PathVariable Long partidoId) {
        boolean inscrit = partidoService.registrarJugador(partidoId);
        if (inscrit) {
            return "T'has registrat correctament!";
        } else {
            return "No s'ha pogut registrar.";
        }
    }

    // Altres mètodes CRUD (si cal) per a crear, editar o esborrar partits
}
