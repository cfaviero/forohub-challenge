package com.aluracursos.forohub.dtoTopico;

import com.aluracursos.forohub.model.Topico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosTopicos(@NotNull
                           Long id,
                           @NotBlank
                           String titulo,
                           @NotBlank
                           String mensaje,
                           LocalDateTime fechaDeCreacion,
                           Boolean status,
                           @NotNull
                           String autor,
                           @NotNull
                           String curso) {


    public DatosTopicos(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaDeCreacion(),
                topico.getStatus(),
                topico.getUsuario().getNombre(),
                topico.getCurso().getNombre()
        );

    }

}
