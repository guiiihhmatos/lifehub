package com.lifehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifehub.DTO.AuthenticationDTO;
import com.lifehub.DTO.LoginResponseDTO;
import com.lifehub.DTO.UsuarioRequestDTO;
import com.lifehub.DTO.UsuarioResponseDTO;
import com.lifehub.config.security.TokenService;
import com.lifehub.exception.emailJaCadastradoException;
import com.lifehub.models.usuario.Usuario;
import com.lifehub.service.UsuarioService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.experimental.var;

@RestController
@Tag(name = "Usuario")
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data)
	{
		UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
	    Authentication auth = this.authenticationManager.authenticate(usernamePassword);
		
	    String token = tokenService.genToken((Usuario) auth.getPrincipal());
	    
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity salvarUsuario(@RequestBody UsuarioRequestDTO requestDTO) {
	    try {

	    	return usuarioService.emailExists(requestDTO)
	                .map(u -> ResponseEntity.status(HttpStatus.CONFLICT).build())
	                .orElseGet(() -> {
	                	
	                	String encryptedPassword = new BCryptPasswordEncoder().encode(requestDTO.getPassword());
	                	requestDTO.setPassword(encryptedPassword);
	    	            usuarioService.salvarUsuario(requestDTO);
	    	            return ResponseEntity.status(HttpStatus.CREATED).build();
	    	        });
	    	
	        
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	    }
	}
	
	@GetMapping
	public List<UsuarioResponseDTO> listarUsuarios()
	{
		return usuarioService.listarUsuarios();
	}
	
	
}
