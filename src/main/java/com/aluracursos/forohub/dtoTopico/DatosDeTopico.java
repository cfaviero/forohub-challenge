package com.aluracursos.forohub.dtoTopico;


import com.aluracursos.forohub.model.Respuesta;
import com.aluracursos.forohub.model.Topico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DatosDeTopico(@NotNull
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
                            String curso,
                            List<Respuesta> respuestas) {


    public DatosDeTopico(Topico topico, List<Respuesta> respuesta) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaDeCreacion(),
                topico.getStatus(),
                topico.getUsuario().getNombre(),
                topico.getCurso().getNombre(),
                respuesta
        );

    }

}
