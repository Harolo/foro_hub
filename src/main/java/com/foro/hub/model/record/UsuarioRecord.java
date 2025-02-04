package com.foro.hub.model.record;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record UsuarioRecord(
        @NotBlank(message = "Nombre es requerido")
         String nombre,

         @NotBlank(message = "Correo electronico es requerido")
         @Email
         String correoElectronico,

         @NotBlank(message = "Contrasena es requerido")
         String contrasena
) {
}
