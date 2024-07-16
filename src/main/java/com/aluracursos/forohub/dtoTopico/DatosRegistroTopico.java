package com.aluracursos.forohub.dtoTopico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Long usuarioId,
        @NotNull
        Long cursoId
) {
}