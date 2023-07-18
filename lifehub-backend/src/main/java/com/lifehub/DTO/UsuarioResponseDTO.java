package com.lifehub.DTO;

import org.springframework.beans.BeanUtils;

import com.lifehub.models.usuario.UserRole;
import com.lifehub.models.usuario.Usuario;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioResponseDTO {
	
	private Integer id;
	private String nome;
    private String telefone;
    private String email;
    private UserRole role;
    
    public UsuarioResponseDTO(Usuario usuario) {
		BeanUtils.copyProperties(usuario, this);
	}

}
