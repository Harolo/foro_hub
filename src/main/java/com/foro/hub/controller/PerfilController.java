package com.foro.hub.controller;

import com.foro.hub.model.record.PerfilRecord;
import com.foro.hub.service.PerfilService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    private final PerfilService perfilService;

    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity registrarPerfil(@Valid @RequestBody PerfilRecord perfilRecord) {
        return perfilService.guardarPerfil(perfilRecord);
    }
}
