package com.aluracursos.forohub.repository;

import com.aluracursos.forohub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombre(String nombreUsuario);
}
