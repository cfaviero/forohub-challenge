package com.aluracursos.forohub.repository;

import com.aluracursos.forohub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITopicoRepository extends JpaRepository<Topico, Long> {

    List<Topico> findTop10ByOrderByFechaDeCreacionAsc();

}
