package com.foro.hub.model.record;

import com.foro.hub.model.Topico;

public record TopicoGetRecord(
        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        String autor,
        String curso

) {

    public TopicoGetRecord(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getAutor().getNombre(), topico.getCurso().getNombre());
    }

}
