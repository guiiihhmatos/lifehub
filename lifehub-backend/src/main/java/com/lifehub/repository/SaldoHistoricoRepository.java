package com.lifehub.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lifehub.models.controleFinanceiro.ControleFinanceiro;
import com.lifehub.models.controleFinanceiro.SaldoHistorico;

public interface SaldoHistoricoRepository extends JpaRepository<SaldoHistorico, Long> {

    SaldoHistorico findByControleFinanceiroAndData(ControleFinanceiro controleFinanceiro, Date data);
    
    @Query("SELECT s FROM SaldoHistorico s WHERE s.controleFinanceiro.id = :controleFinanceiroId")
    List<SaldoHistorico> findByControleFinanceiroId(@Param("controleFinanceiroId") Long controleFinanceiroId);
}
