package com.lifehub.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.lifehub.models.controleFinanceiro.ControleFinanceiro;
import com.lifehub.models.controleFinanceiro.SaldoHistorico;
import com.lifehub.repository.SaldoHistoricoRepository;

@Service
public class SaldoHistoricoService {
	
	@Autowired
	private SaldoHistoricoRepository saldoHistoricoRepository;
	
	@Autowired
	private ControleFinanceiroService controleFinanceiroService;
	
	@Transactional(readOnly = true)
	public SaldoHistorico buscarSaldoHistoricoPorData(ControleFinanceiro controleFinanceiro, Date data) {
        return saldoHistoricoRepository.findByControleFinanceiroAndData(controleFinanceiro, data);
    }
	
	@Transactional
    public void salvarSaldoHistorico(SaldoHistorico saldoHistorico) {
        saldoHistoricoRepository.save(saldoHistorico);
    }
    
	@Transactional(readOnly = true)
    public List<SaldoHistorico> listarHistoricoPorControleFinanceiro(@PathVariable Long id)
    {
    	ControleFinanceiro controleFinanceiro = controleFinanceiroService.findById(id);

		if (controleFinanceiro != null) {
			return saldoHistoricoRepository.findByControleFinanceiroId(id);
		}

		return Collections.emptyList();
    }
    
}
