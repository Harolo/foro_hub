package com.foro.hub.service;

import com.foro.hub.model.record.TopicoActualizarRecord;
import com.foro.hub.model.record.TopicoGetRecord;
import com.foro.hub.model.record.TopicoRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface TopicoService {

    ResponseEntity guardarTopico(TopicoRecord topicoRecord);

    Page<TopicoGetRecord> listarTopicos(Pageable paginacion);

    ResponseEntity actualizarTopico(Long id, TopicoActualizarRecord topicoActualizarRecord);

    ResponseEntity eliminarTopico(Long id);
}
