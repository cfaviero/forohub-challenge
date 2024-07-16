package com.aluracursos.forohub.dtoRespuesta;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(@NotBlank
                                     String mensaje,
                                     @NotNull
                                     Long topico,
                                     @NotNull
                                     Long usuarioId) {

}
