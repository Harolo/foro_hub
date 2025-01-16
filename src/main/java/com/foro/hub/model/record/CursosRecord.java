package com.foro.hub.model.record;

import jakarta.validation.constraints.NotBlank;

public record CursosRecord(
        @NotBlank(message = "Categoria es requerido")
        String categoria,

        @NotBlank(message = "Nombre de curso es requerido")
        String nombre) {
}
