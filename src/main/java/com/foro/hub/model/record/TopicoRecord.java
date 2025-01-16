package com.foro.hub.model.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoRecord(
        @NotBlank(message = "Titulo es requerido")
        String titulo,
        @NotBlank(message = "Mensaje es requerido")
        String mensaje,
        @NotNull(message = "Autor es requerido")
        Long autorId,
        @NotNull(message = "Curso es requerido")
        Long cursoId
) {
}
