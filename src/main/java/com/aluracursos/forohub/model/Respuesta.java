package com.aluracursos.forohub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;
    private LocalDateTime fechaDeCreacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private Boolean solucion;

    public Respuesta(String mensaje, Topico topico, LocalDateTime fecha, Usuario usuario, Boolean solucion) {
        this.mensaje = mensaje;
        this.topico = topico;
        this.fechaDeCreacion = fecha;
        this.usuario = usuario;
        this.solucion = solucion;
    }

    public void actualizarRespuesta(Respuesta respuesta) {
        this.mensaje = respuesta.getMensaje();
        this.fechaDeCreacion = LocalDateTime.now();

    }
}