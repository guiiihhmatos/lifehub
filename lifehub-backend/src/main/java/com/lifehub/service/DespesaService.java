package com.lifehub.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.lifehub.DTO.DespesaDTO;
import com.lifehub.models.controleFinanceiro.ControleFinanceiro;
import com.lifehub.models.controleFinanceiro.Despesa;
import com.lifehub.repository.DespesaRepository;

@Service
public class DespesaService {

	@Autowired
	private DespesaRepository despesaRepository;

	@Autowired
	private ControleFinanceiroService controleFinanceiroService;

	@Transactional(rollbackFor = Exception.class)
	public Despesa salvarDespesa(DespesaDTO despesaDTO) {

		ControleFinanceiro controleFinanceiro = controleFinanceiroService
				.findById(despesaDTO.getId_controleFinanceiro());

		Despesa despesa = new Despesa();
		BeanUtils.copyProperties(despesaDTO, despesa);
		despesa.setControleFinanceiro(controleFinanceiro);

		BigDecimal novoSaldo = controleFinanceiro.getSaldo().subtract(despesaDTO.getValor());
		controleFinanceiro.setSaldo(novoSaldo);
		controleFinanceiroService.salvarControleFinanceiro(controleFinanceiro);

		return despesaRepository.save(despesa);
	}

	@Transactional(readOnly = true)
	public List<Despesa> listarDespesaPorControleFinanceiro(@PathVariable Long id) {
		ControleFinanceiro controleFinanceiro = controleFinanceiroService.findById(id);

		if (controleFinanceiro != null) {
			return despesaRepository.findByControleFinanceiroId(id);
		}

		return Collections.emptyList();
	}

}
