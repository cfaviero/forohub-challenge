package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.dtoTopico.ActualizarTopico;
import com.aluracursos.forohub.dtoTopico.DatosDeTopico;
import com.aluracursos.forohub.dtoTopico.DatosRegistroTopico;
import com.aluracursos.forohub.dtoTopico.DatosTopicos;
import com.aluracursos.forohub.service.TopicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoService service;


    @PutMapping("/{id}")
    @Transactional
    @Operation(summary = "Actualiza el topico ya existente")
    public ResponseEntity<ActualizarTopico> actualizarTopico(@PathVariable Long id) {
        var respuesta = service.actualizarTopico(id);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Elimina un topico")
    public ResponseEntity<String> eliminarTopico(@PathVariable Long id) {
        var respuesta = service.eliminarTopico(id);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Crea un nuevo topico")
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        service.nuevoTopico(datos);
    }

    @GetMapping
    @Operation(summary = "Obtiene los topicos existentes")
    public ResponseEntity<Page<DatosTopicos>> listaTopicos(@PageableDefault(size = 10)Pageable pageable) {
        var respuesta = service.listarTopico(pageable);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/10primeros")
    @Operation(summary = "Obtiene los 10 primeros topicos ordenados por fecha de creacion")
    public ResponseEntity<List<DatosTopicos>> listaFechaCreacion() {
        var respuesta = service.listarFechaCreacion();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene los datos del topico solicitado con id")
    public ResponseEntity<DatosDeTopico> traerTopicoId(@PathVariable Long id) {
        var topico = service.traerTopicoId(id);
        return ResponseEntity.ok(topico);
    }


}
