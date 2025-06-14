package com.practica.Autenticacion.repositorio;

import com.practica.Autenticacion.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
