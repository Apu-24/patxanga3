package com.patxanga.futbol.services;

import com.patxanga.futbol.models.Partido;
import com.patxanga.futbol.repositories.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    public List<Partido> listarPartidos() {
        return partidoRepository.findAll();
    }

    public boolean registrarJugador(Long partidoId) {
        Partido partido = partidoRepository.findById(partidoId).orElse(null);
        if (partido != null && partido.getJugadores().size() < partido.getMaxJugadores()) {
            // Aquí afegeixes el jugador al partit
            return true;
        }
        return false;
    }

    // Altres mètodes per gestionar la creació o actualització de partits
}
