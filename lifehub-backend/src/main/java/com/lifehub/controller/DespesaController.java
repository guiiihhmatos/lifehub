package com.lifehub.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifehub.DTO.DespesaDTO;
import com.lifehub.models.controleFinanceiro.ControleFinanceiro;
import com.lifehub.models.controleFinanceiro.Despesa;
import com.lifehub.service.ControleFinanceiroService;
import com.lifehub.service.DespesaService;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;
    
    @Autowired
    private ControleFinanceiroService controleFinanceiroService;

    @PostMapping
    public Despesa criarDespesa(@RequestBody DespesaDTO despesaDTO) {
    	
        ControleFinanceiro controleFinanceiro = controleFinanceiroService.findById(despesaDTO.getId_controleFinanceiro());

        Despesa despesa = new Despesa();
        despesa.setDescricao(despesaDTO.getDescricao());
        despesa.setValor(despesaDTO.getValor());
        despesa.setData(despesaDTO.getData());
        despesa.setControleFinanceiro(controleFinanceiro);

        BigDecimal novoSaldo = controleFinanceiro.getSaldo().subtract(despesaDTO.getValor());
        controleFinanceiro.setSaldo(novoSaldo);
        controleFinanceiroService.salvarControleFinanceiro(controleFinanceiro);

        return despesaService.salvarDespesa(despesa);
    }
    
    @GetMapping("/{id}")
    public List<Despesa> listarDespesaPorControleFinanceiro(@PathVariable("id") Long id)
    {
    	return despesaService.listarDespesaPorControleFinanceiro(id);
    }

}
