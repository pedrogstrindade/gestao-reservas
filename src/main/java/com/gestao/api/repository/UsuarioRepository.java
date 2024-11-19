package com.gestao.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestao.api.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}