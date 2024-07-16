package com.aluracursos.forohub.dtoRespuesta;

import com.aluracursos.forohub.model.Respuesta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRespuesta(@NotNull
                             Long id,
                             @NotBlank
                             String mensaje,
                             @NotNull
                             Long topico,
                             LocalDateTime fechaDeCreacion,
                             @NotNull
                             Long usuario,
                             Boolean solucion) {

    public DatosRespuesta(Respuesta respuesta) {
        this(respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getTopico().getId(),
                respuesta.getFechaDeCreacion(),
                respuesta.getUsuario().getId(),
                respuesta.getSolucion()
        );
    }
}
