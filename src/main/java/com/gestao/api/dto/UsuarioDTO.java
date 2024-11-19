package com.gestao.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    
    private String nome;
    private String email;
    private Boolean user;
    private Boolean admin;
}