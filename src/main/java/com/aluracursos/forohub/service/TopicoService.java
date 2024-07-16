package com.aluracursos.forohub.service;

import com.aluracursos.forohub.dtoTopico.ActualizarTopico;
import com.aluracursos.forohub.dtoTopico.DatosDeTopico;
import com.aluracursos.forohub.dtoTopico.DatosRegistroTopico;
import com.aluracursos.forohub.dtoTopico.DatosTopicos;
import com.aluracursos.forohub.model.Topico;
import com.aluracursos.forohub.repository.ICursoRepository;
import com.aluracursos.forohub.repository.IRespuestaRepository;
import com.aluracursos.forohub.repository.ITopicoRepository;
import com.aluracursos.forohub.repository.IUsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private ITopicoRepository topicoRepository;
    @Autowired
    private ICursoRepository cursoRepository;
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private IRespuestaRepository respuestaRepository;

    public void nuevoTopico(DatosRegistroTopico datos) {

        var titulo = datos.titulo();
        var mensaje = datos.mensaje();
        var autor = usuarioRepository.getReferenceById(datos.usuarioId());
        var curso = cursoRepository.getReferenceById(datos.cursoId());

        var nuevo = new Topico(titulo, mensaje, autor, curso);
        topicoRepository.save(nuevo);
    }


    public Page<DatosTopicos> listarTopico(Pageable pageable) {
        return topicoRepository.findAll(pageable).map(DatosTopicos::new);
    }

    public List<DatosTopicos> listarFechaCreacion(){
        return topicoRepository.findTop10ByOrderByFechaDeCreacionAsc().stream().map(DatosTopicos::new).toList();
    }

    public DatosDeTopico traerTopicoId(Long id) {
        var topicoRepo = topicoRepository.findById(id);
        if (topicoRepo.isPresent()) {
           var topico = topicoRepo.get();
           var respuesta = respuestaRepository.findByTopico_idEquals(topico.getId());
           return new DatosDeTopico(topico, respuesta);
        } else {
            return null;
        }
    }

    public ActualizarTopico actualizarTopico(Long id) {
        var topico = topicoRepository.getReferenceById(id);
        topico.actualizarTopico(topico);
        return new ActualizarTopico(topico);
    }

    public String eliminarTopico(Long id) {
        var topico = topicoRepository.findById(id);
        if (topico.isEmpty() || id == null) {
            throw new ValidationException("No existe el topico que desea eliminar: " + id);
        }
        var topicoAEliminiar = topico.get().getId();
        respuestaRepository.deleteByTopico_id(topicoAEliminiar);
        topicoRepository.deleteById(topicoAEliminiar);
        return "Topico eliminado correctamente";
    }
}
