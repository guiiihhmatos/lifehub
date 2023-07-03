package com.lifehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifehub.models.controleFinanceiro.ControleFinanceiro;

public interface ControleFinanceiroRepository extends JpaRepository<ControleFinanceiro, Long> {
}
