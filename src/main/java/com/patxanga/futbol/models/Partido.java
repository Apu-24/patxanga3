package com.patxanga.futbol.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaHora; // Fecha y hora del partido

    @ManyToOne // Muchos partidos pueden jugarse en un Campo
    @JoinColumn(name = "campo_id") // Define la FK hacia Campo
    private Campo campo;

    private String estado; // Ejemplo: "Pendiente", "Completado", etc.

    private Integer maxJugadores; // Máximo número de jugadores permitidos

    @OneToMany(mappedBy = "partido", cascade = CascadeType.ALL) // Relación con jugadores inscritos
    private List<Jugador> jugadores;

    public Partido() {} // Constructor vacío

    public Partido(LocalDateTime fechaHora, Campo campo, String estado, Integer maxJugadores) {
        this.fechaHora = fechaHora;
        this.campo = campo;
        this.estado = estado;
        this.maxJugadores = maxJugadores;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fechaHora;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fechaHora = fecha;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Integer getMaxJugadores() {
        return maxJugadores;
    }

    public void setMaxJugadores(Integer maxJugadores) {
        this.maxJugadores = maxJugadores;
    }
}

