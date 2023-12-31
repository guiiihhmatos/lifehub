package com.lifehub.DTO;

import com.lifehub.models.usuario.UserRole;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioRequestDTO {

	private String nome;
    private String telefone;
    private String email;
    private UserRole role;
    private String password;
}
