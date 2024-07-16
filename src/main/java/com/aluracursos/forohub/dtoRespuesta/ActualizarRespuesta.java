package com.aluracursos.forohub.dtoRespuesta;

import com.aluracursos.forohub.model.Respuesta;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record ActualizarRespuesta(@NotBlank
                                  String mensaje,
                                  LocalDateTime fechaActualizacion) {

    public ActualizarRespuesta(Respuesta respuesta) {
        this(respuesta.getMensaje(),
        LocalDateTime.now());
    }
}
