package com.patxanga.futbol.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Campo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;

    @OneToMany(mappedBy = "campo", cascade = CascadeType.ALL) // Un campo puede albergar varios partidos
    private List<Partido> partidos;

    public Campo() {} // Constructor vacío

    public Campo(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
    private boolean disponibilidad; // true si está disponible, false si no está disponible
    // Getter para id
    public Long getId() {
        return id;
    }

    // Setter para id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para direccion
    public String getDireccion() {
        return direccion;
    }

    // Setter para direccion
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Getter para disponibilidad
    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    // Setter para disponibilidad
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
