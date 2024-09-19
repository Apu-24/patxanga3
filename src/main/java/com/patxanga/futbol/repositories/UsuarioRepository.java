package com.patxanga.futbol.repositories;

import com.patxanga.futbol.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método personalizado para encontrar un usuario por su email
    Optional<Usuario> findByEmail(String email);

    // Otros métodos personalizados pueden agregarse según necesidades futuras
}
