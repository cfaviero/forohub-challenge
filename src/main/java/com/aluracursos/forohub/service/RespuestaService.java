package com.aluracursos.forohub.service;

import com.aluracursos.forohub.dtoRespuesta.ActualizarRespuesta;
import com.aluracursos.forohub.dtoRespuesta.DatosRegistroRespuesta;
import com.aluracursos.forohub.dtoRespuesta.DatosRespuesta;
import com.aluracursos.forohub.model.Respuesta;
import com.aluracursos.forohub.repository.ICursoRepository;
import com.aluracursos.forohub.repository.IRespuestaRepository;
import com.aluracursos.forohub.repository.ITopicoRepository;
import com.aluracursos.forohub.repository.IUsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class RespuestaService {

    @Autowired
    private ITopicoRepository topicoRepository;
    @Autowired
    private ICursoRepository cursoRepository;
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private IRespuestaRepository respuestaRepository;

    public Page<DatosRespuesta> listaRespuestas(Pageable pageable) {
        var respuestaRepo = respuestaRepository.findAll(pageable);
        if (respuestaRepo.isEmpty() || respuestaRepo == null) {
            throw new ValidationException("Sin respuestas hasta el momento");
        }
        return respuestaRepo.map(DatosRespuesta::new);
    }

    public void nuevaRespuesta(DatosRegistroRespuesta datos) {

        var mensaje = datos.mensaje();
        var topico = topicoRepository.getReferenceById(datos.topico());
        var fecha = LocalDateTime.now();
        var autor = usuarioRepository.getReferenceById(datos.usuarioId());
        var solucion = false;


        var nuevo = new Respuesta(mensaje, topico, fecha, autor, solucion);
        respuestaRepository.save(nuevo);

    }

    public ActualizarRespuesta actualizarRespuesta(Long id) {
        var respuesta = respuestaRepository.getReferenceById(id);
        respuesta.actualizarRespuesta(respuesta);
        return new ActualizarRespuesta(respuesta);
    }

    public String eliminarRespuesta(Long id) {
        var respuesta = respuestaRepository.findById(id);
        if (respuesta.isEmpty() || id == null) {
            throw new ValidationException("No existe la respuesta que desea eliminar: " + id);
        }
        respuestaRepository.deleteById(id);
        return "Respuesta eliminada correctamente";


    }
}
