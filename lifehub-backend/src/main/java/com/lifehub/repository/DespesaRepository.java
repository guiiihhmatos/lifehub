package com.lifehub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lifehub.models.controleFinanceiro.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{
	
	@Query("SELECT d FROM Despesa d WHERE d.controleFinanceiro.id = :controleFinanceiroId")
    List<Despesa> findByControleFinanceiroId(@Param("controleFinanceiroId") Long controleFinanceiroId);
}
