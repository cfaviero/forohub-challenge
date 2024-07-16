package com.aluracursos.forohub.repository;

import com.aluracursos.forohub.model.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRespuestaRepository extends JpaRepository<Respuesta, Long> {

    List<Respuesta> findByTopico_idEquals(Long id);

    void deleteByTopico_id(Long id);

}
