package com.practica.Autenticacion.service;

import com.practica.Autenticacion.domain.Usuario;
import com.practica.Autenticacion.repositorio.UsuarioRepository;
import com.practica.Autenticacion.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String login(String username, String password) {
        Usuario user = usuarioRepo.findByUsername(username).orElseThrow();
        System.out.println("user: "+user.getUsername());
        System.out.println("contra: "+user.getPassword());

        if (passwordEncoder.matches(password, user.getPassword())) {
            return jwtUtil.generateToken(user.getUsername());
        }
        throw new RuntimeException("Credenciales incorrectas");
    }
}