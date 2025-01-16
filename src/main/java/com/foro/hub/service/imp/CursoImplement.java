package com.foro.hub.service.imp;

import com.foro.hub.model.Curso;
import com.foro.hub.model.record.CursosRecord;
import com.foro.hub.repository.CursoRepository;
import com.foro.hub.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CursoImplement implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoImplement(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public ResponseEntity guardarCurso(CursosRecord cursosRecord) {
        cursoRepository.save(new Curso(cursosRecord));
        return ResponseEntity.ok("Curso registrado con exito");
    }
}
