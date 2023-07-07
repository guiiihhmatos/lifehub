package com.lifehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifehub.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	boolean existsByEmail(String email);

	Usuario findByEmail(String email);
}
