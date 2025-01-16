package com.foro.hub.controller;

import com.foro.hub.model.record.CursosRecord;
import com.foro.hub.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity registrarCurso(@RequestBody @Valid CursosRecord cursosRecord) {
        return cursoService.guardarCurso(cursosRecord);

    }
}
