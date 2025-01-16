package com.foro.hub.service;

import com.foro.hub.model.record.PerfilRecord;
import org.springframework.http.ResponseEntity;

public interface PerfilService {
    ResponseEntity guardarPerfil(PerfilRecord perfilRecord);
}
