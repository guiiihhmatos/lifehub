package com.lifehub.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.lifehub.DTO.ReceitaDTO;
import com.lifehub.models.controleFinanceiro.ControleFinanceiro;
import com.lifehub.models.controleFinanceiro.Receita;
import com.lifehub.models.controleFinanceiro.SaldoHistorico;
import com.lifehub.repository.ReceitaRepository;

@Service
public class ReceitaService {
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	@Autowired
	private ControleFinanceiroService controleFinanceiroService;
	
	@Autowired
	private SaldoHistoricoService saldoHistoricoService;
	
	@Transactional
	public Receita salvarReceita(ReceitaDTO receitaDTO) throws Exception {
		
		ControleFinanceiro controleFinanceiro = controleFinanceiroService
				.findById(receitaDTO.getId_controleFinanceiro());
		
		Receita receita = new Receita();
		
		BeanUtils.copyProperties(receitaDTO, receita);
		
		receita.setControleFinanceiro(controleFinanceiro);
		
		BigDecimal novoSaldo = controleFinanceiro.getSaldo().add(receitaDTO.getValor());
		controleFinanceiro.setSaldo(novoSaldo);
		controleFinanceiroService.salvarControleFinanceiro(controleFinanceiro);
		
		Date dataAtual = new Date();
	    SaldoHistorico saldoHistorico = saldoHistoricoService.buscarSaldoHistoricoPorData(controleFinanceiro, dataAtual);

	    if (saldoHistorico != null) {
	    	
	        saldoHistorico.setSaldo(controleFinanceiro.getSaldo());
	        
	    } else {
	    	
	        saldoHistorico = new SaldoHistorico();
	        saldoHistorico.setData(dataAtual);
	        saldoHistorico.setSaldo(controleFinanceiro.getSaldo());
	        saldoHistorico.setControleFinanceiro(controleFinanceiro);
	    }

	    saldoHistoricoService.salvarSaldoHistorico(saldoHistorico);
		
		return receitaRepository.save(receita);
		
	}
	
	@Transactional(readOnly = true)
	public List<Receita> listarReceitaPorControleFinanceiro(@PathVariable Long id) {
		ControleFinanceiro controleFinanceiro = controleFinanceiroService.findById(id);

		if (controleFinanceiro != null) {
			return receitaRepository.findByControleFinanceiroId(id);
		}

		return Collections.emptyList();
	}

	
}
