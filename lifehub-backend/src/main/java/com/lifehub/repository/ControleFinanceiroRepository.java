package com.lifehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lifehub.models.controleFinanceiro.ControleFinanceiro;

public interface ControleFinanceiroRepository extends JpaRepository<ControleFinanceiro, Long> {
	
	@Query("SELECT c FROM ControleFinanceiro c WHERE c.usuario.id = :usuarioId")
	ControleFinanceiro findByUsuario(@Param("usuarioId") Long usuarioId);
}
