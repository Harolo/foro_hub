package com.foro.hub.controller;

import com.foro.hub.model.record.UsuarioRecord;
import com.foro.hub.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping()
    @Transactional
    public ResponseEntity guardarUsuario(@RequestBody @Valid UsuarioRecord usuarioRecord) {
        return usuarioService.guardarUsuario(usuarioRecord);
    }
}
