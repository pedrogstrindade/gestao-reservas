package com.gestao.api.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestao.api.dto.UsuarioDTO;
import com.gestao.api.model.Usuario;
import com.gestao.api.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastrarUsuario(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> acharUsuarioPeloId(@PathVariable("id") Long id) {
        UsuarioDTO usuario = usuarioService.acharUsuarioPeloId(id);

        if (Objects.isNull(usuario)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioDTO>> listarUsuarios(Pageable paginacao) {
        return ResponseEntity.ok().body(usuarioService.listarUsuarios(paginacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable("id") Long id) {
        UsuarioDTO usuario = usuarioService.acharUsuarioPeloId(id);

        if (Objects.isNull(usuario)) {
            return ResponseEntity.notFound().build();
        }

        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@RequestBody @Valid Usuario dadosUsuario, @PathVariable("id") Long id) {
        UsuarioDTO usuario = usuarioService.acharUsuarioPeloId(id);

        if (Objects.isNull(usuario)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(usuarioService.atualizarUsuario(dadosUsuario, id));
    }

    @Autowired
    private UsuarioService usuarioService;
}