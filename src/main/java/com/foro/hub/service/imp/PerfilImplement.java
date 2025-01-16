package com.foro.hub.service.imp;

import com.foro.hub.model.Perfil;
import com.foro.hub.model.record.PerfilRecord;
import com.foro.hub.repository.PerfilRepository;
import com.foro.hub.service.PerfilService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PerfilImplement implements PerfilService {

    private final PerfilRepository perfilRepository;

    public PerfilImplement(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }


    @Override
    public ResponseEntity guardarPerfil(PerfilRecord perfilRecord) {
        perfilRepository.save(new Perfil(perfilRecord));
        return ResponseEntity.ok("Perfil registrado con exito");
    }
}
