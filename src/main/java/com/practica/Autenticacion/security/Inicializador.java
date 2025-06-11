package com.practica.Autenticacion.security;


import com.practica.Autenticacion.domain.Usuario;
import com.practica.Autenticacion.repositorio.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Inicializador {

    @Bean
    public CommandLineRunner initData(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (usuarioRepository.findByUsername("admin").isEmpty()) {
                Usuario admin = new Usuario("admin", passwordEncoder.encode("admin123"));
                usuarioRepository.save(admin);
                System.out.println("Usuario admin creado");
            }
        };
    }
}