package com.lifehub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lifehub.models.controleFinanceiro.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{
	
	@Query("SELECT r FROM Receita r WHERE r.controleFinanceiro.id = :controleFinanceiroId")
    List<Receita> findByControleFinanceiroId(@Param("controleFinanceiroId") Long controleFinanceiroId);
}
