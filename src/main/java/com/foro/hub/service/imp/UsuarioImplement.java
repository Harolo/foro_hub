package com.foro.hub.service.imp;

import com.foro.hub.model.Perfil;
import com.foro.hub.model.Usuario;
import com.foro.hub.model.record.UsuarioRecord;
import com.foro.hub.repository.PerfilRepository;
import com.foro.hub.repository.UsuarioRepository;
import com.foro.hub.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioImplement implements UsuarioService {


    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioImplement(UsuarioRepository usuarioRepository, PerfilRepository perfilRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.perfilRepository = perfilRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public ResponseEntity guardarUsuario(UsuarioRecord usuarioRecord) {

        usuarioRepository.save(new Usuario(usuarioRecord,passwordEncoder));

        return ResponseEntity.ok("Usuario registrado con exito");

    }
}
