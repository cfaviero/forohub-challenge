package com.aluracursos.forohub.repository;

import com.aluracursos.forohub.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepository extends JpaRepository<Curso, Long> {
}
