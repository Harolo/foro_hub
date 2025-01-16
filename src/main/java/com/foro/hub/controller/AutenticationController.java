package com.foro.hub.controller;

import com.foro.hub.model.Usuario;
import com.foro.hub.model.record.DatosAutenticacion;
import com.foro.hub.model.record.DatosJWTToken;
import com.foro.hub.service.imp.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AutenticationController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacion datosAutenticacion) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacion.nombre(), datosAutenticacion.contrasena());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}
