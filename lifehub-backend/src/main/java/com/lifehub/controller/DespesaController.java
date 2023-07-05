package com.lifehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifehub.DTO.DespesaDTO;
import com.lifehub.models.controleFinanceiro.Despesa;
import com.lifehub.service.DespesaService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Despesas")
@RequestMapping("/despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @PostMapping
    public Despesa criarDespesa(@RequestBody DespesaDTO despesaDTO) throws Exception {

        return despesaService.salvarDespesa(despesaDTO);
    }
    
    @GetMapping("/{id}")
    public List<Despesa> listarDespesaPorControleFinanceiro(@PathVariable("id") Long id) throws Exception {
    	return despesaService.listarDespesaPorControleFinanceiro(id);
    }

}
