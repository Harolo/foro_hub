package com.foro.hub.controller;

import com.foro.hub.model.record.TopicoActualizarRecord;
import com.foro.hub.model.record.TopicoGetRecord;
import com.foro.hub.model.record.TopicoRecord;
import com.foro.hub.service.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity registrarTopico(@Valid @RequestBody  TopicoRecord topicoRecord) {
        return topicoService.guardarTopico(topicoRecord);
    }


    @GetMapping
    public Page<TopicoGetRecord> listarTopicos(@PageableDefault(size = 10) Pageable paginacion) {
        return topicoService.listarTopicos(paginacion);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable Long id, @Valid @RequestBody TopicoActualizarRecord topicoActualizarRecord) {
        return topicoService.actualizarTopico(id, topicoActualizarRecord);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        return topicoService.eliminarTopico(id);
    }



}
