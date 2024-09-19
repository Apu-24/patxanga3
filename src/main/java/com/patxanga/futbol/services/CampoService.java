package com.patxanga.futbol.services;

import com.patxanga.futbol.models.Campo;
import com.patxanga.futbol.repositories.CampoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampoService {

    @Autowired
    private CampoRepository campoRepository;

    // Obtener todos los campos
    public List<Campo> getAllCampos() {
        return campoRepository.findAll();
    }

    // Guardar un nuevo campo
    public Campo saveCampo(Campo campo) {
        return campoRepository.save(campo);
    }

    // Obtener un campo por su ID
    public Optional<Campo> getCampoById(Long id) {
        return campoRepository.findById(id);
    }

    // Buscar campos por nombre
    public List<Campo> getCamposByNombre(String nombre) {
        return campoRepository.findByNombre(nombre);
    }

    // Eliminar un campo por ID
    public void deleteCampo(Long id) {
        campoRepository.deleteById(id);
    }
}
