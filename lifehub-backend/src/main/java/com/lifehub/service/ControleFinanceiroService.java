package com.lifehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.lifehub.models.controleFinanceiro.ControleFinanceiro;
import com.lifehub.repository.ControleFinanceiroRepository;

@Service
public class ControleFinanceiroService {
	
	@Autowired
	private ControleFinanceiroRepository financeiroRepository;
	
	@Transactional(readOnly = true)
	public List<ControleFinanceiro> listarControle()
	{
		return financeiroRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public ControleFinanceiro findById(@PathVariable Long id) {
		ControleFinanceiro result = financeiroRepository.findById(id).get();
		return result;
	}

	@Transactional(readOnly = true)
    public ControleFinanceiro salvarControleFinanceiro(ControleFinanceiro controleFinanceiro) {
        return financeiroRepository.save(controleFinanceiro);
    }
	
}
