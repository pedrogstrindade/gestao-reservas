package com.gestao.api.model;

import com.gestao.api.dto.UsuarioDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(nullable = false)
    private String nome;
    
    @NotNull
    @Column(nullable = false, unique = true)
    private String email;
    
    @NotNull
    @Column(nullable = false)
    private String senha;
    
    @NotNull
    @Column(nullable = false)
    private Boolean user;
    
    @NotNull
    @Column(nullable = false)
    private Boolean admin;

    public UsuarioDTO toDTO() {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNome(nome);
        dto.setEmail(email);
        dto.setAdmin(admin);
        dto.setUser(user);

        return dto;
    }
}