package com.lifehub.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioRequestDTO {

	private String nome;
    private String telefone;
    private String email;
    private String senha;
}
