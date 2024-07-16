package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.dtoRespuesta.ActualizarRespuesta;
import com.aluracursos.forohub.dtoRespuesta.DatosRegistroRespuesta;
import com.aluracursos.forohub.service.RespuestaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {

    @Autowired
    private RespuestaService service;

    @PostMapping
    @Transactional
    @Operation(summary = "Registra una nueva respuesta")
    public void registrarRespuesta(@RequestBody @Valid DatosRegistroRespuesta datos) {
        service.nuevaRespuesta(datos);
    }

    @PutMapping("/{id}")
    @Transactional
    @Operation(summary = "Actualiza la respuesta con id existente")
    public ResponseEntity<ActualizarRespuesta> actualizarRespuesta(@PathVariable Long id) {
        var respuesta = service.actualizarRespuesta(id);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Elimina una respuesta con id existente")
    public ResponseEntity<String> eliminarRespuesta(@PathVariable Long id) {
        var respuesta = service.eliminarRespuesta(id);
        return ResponseEntity.ok(respuesta);
    }
}
