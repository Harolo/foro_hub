package com.foro.hub.service;

import com.foro.hub.model.record.UsuarioRecord;
import org.springframework.http.ResponseEntity;

public interface UsuarioService {
    ResponseEntity guardarUsuario(UsuarioRecord usuarioRecord);
}
