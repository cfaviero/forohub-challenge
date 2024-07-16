package com.aluracursos.forohub.dtoTopico;

import com.aluracursos.forohub.model.Topico;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record ActualizarTopico(@NotBlank
                               String titulo,
                               @NotBlank
                               String mensaje,
                               LocalDateTime fechaActualizacion) {

    public ActualizarTopico(Topico topico) {
        this(topico.getTitulo(),
             topico.getMensaje(),
             topico.getFechaDeCreacion()
        );


    }
}
