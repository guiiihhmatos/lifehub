package com.lifehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifehub.DTO.UsuarioRequestDTO;
import com.lifehub.exception.emailJaCadastradoException;
import com.lifehub.models.usuario.Usuario;
import com.lifehub.service.UsuarioService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Usuario")
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity salvarUsuario(@RequestBody UsuarioRequestDTO requestDTO) {
	    try {

	    	return usuarioService.emailExists(requestDTO)
	                .map(u -> ResponseEntity.status(HttpStatus.CONFLICT).build())
	                .orElseGet(() -> {
	    	            usuarioService.salvarUsuario(requestDTO);
	    	            return ResponseEntity.status(HttpStatus.CREATED).build();
	    	        });
	    	
	        
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	    }
	}
	
	@GetMapping
	public List<Usuario> listarUsuarios()
	{
		return usuarioService.listarUsuarios();
	}
	
	
}
