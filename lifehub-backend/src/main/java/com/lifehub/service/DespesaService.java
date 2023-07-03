package com.lifehub.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.lifehub.models.controleFinanceiro.ControleFinanceiro;
import com.lifehub.models.controleFinanceiro.Despesa;
import com.lifehub.repository.DespesaRepository;

@Service
public class DespesaService {
	
	@Autowired
	private DespesaRepository despesaRepository;
	
	@Autowired
	private ControleFinanceiroService controleFinanceiroService;
	
	public Despesa salvarDespesa(Despesa despesa) {
        return despesaRepository.save(despesa);
    }
	
	public List<Despesa> listarDespesaPorControleFinanceiro(@PathVariable Long id) {
	    ControleFinanceiro controleFinanceiro = controleFinanceiroService.findById(id);
	    
	    if (controleFinanceiro != null) {
	        return despesaRepository.findByControleFinanceiroId(id);
	    }
	    
	    return Collections.emptyList();
	}

}
