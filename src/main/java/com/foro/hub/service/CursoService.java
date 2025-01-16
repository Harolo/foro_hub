package com.foro.hub.service;

import com.foro.hub.model.record.CursosRecord;
import org.springframework.http.ResponseEntity;

public interface CursoService {

    ResponseEntity guardarCurso(CursosRecord cursosRecord);
}
