package com.patxanga.futbol.controllers;

import com.patxanga.futbol.models.Campo;
import com.patxanga.futbol.services.CampoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/campos")
public class CampoController {

    @Autowired
    private CampoService campoService;

    @GetMapping
    public List<Campo> getAllCampos() {
        return campoService.getAllCampos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campo> getCampoById(@PathVariable Long id) {
        Optional<Campo> campo = campoService.getCampoById(id);
        return campo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Campo createCampo(@RequestBody Campo campo) {
        return campoService.saveCampo(campo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampo(@PathVariable Long id) {
        campoService.deleteCampo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nombre/{nombre}")
    public List<Campo> getCamposByNombre(@PathVariable String nombre) {
        return campoService.getCamposByNombre(nombre);
    }
}
