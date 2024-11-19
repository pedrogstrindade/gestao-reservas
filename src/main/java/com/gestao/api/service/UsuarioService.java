package com.gestao.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gestao.api.dto.UsuarioDTO;
import com.gestao.api.model.Usuario;
import com.gestao.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public UsuarioDTO acharUsuarioPeloId(Long id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

        if (usuarioOpt.isPresent()) {
            return usuarioOpt.get().toDTO();
        }

        return null;
    }

    public Page<UsuarioDTO> listarUsuarios(Pageable paginacao) {
        return usuarioRepository.findAll(paginacao).map(Usuario::toDTO);
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario atualizarUsuario(Usuario dadosUsuario, Long id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            usuario.setNome(dadosUsuario.getNome());
            usuario.setSenha(dadosUsuario.getSenha());
            usuario.setEmail(dadosUsuario.getEmail());
            usuario.setUser(dadosUsuario.getUser());
            usuario.setAdmin(dadosUsuario.getAdmin());

            return usuarioRepository.save(usuario);
        }

        return null;
    }

    @Autowired
    private UsuarioRepository usuarioRepository;
}