package com.lifehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifehub.DTO.UsuarioRequestDTO;
import com.lifehub.models.Usuario;
import com.lifehub.service.UsuarioService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Usuario")
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@PostMapping
	public Usuario salvarUsuario(@RequestBody UsuarioRequestDTO  requestDTO) throws Exception {
		
        return usuarioService.salvarUsuario(requestDTO);
	}

	
	@GetMapping
	public List<Usuario> listarUsuarios()
	{
		return usuarioService.listarUsuarios();
	}
	
	
}
