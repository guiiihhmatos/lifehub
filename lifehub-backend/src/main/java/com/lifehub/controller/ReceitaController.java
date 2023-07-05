package com.lifehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifehub.DTO.ReceitaDTO;
import com.lifehub.models.controleFinanceiro.Receita;
import com.lifehub.service.ReceitaService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Receitas")
@RequestMapping("/receitas")
public class ReceitaController {
	
	@Autowired
	private ReceitaService receitaService;
	
	@PostMapping
	public Receita criarReceita(@RequestBody ReceitaDTO receitaDTO) throws Exception {
		return receitaService.salvarReceita(receitaDTO);
	}
	
	@GetMapping("/{id}")
    public List<Receita> listarReceitaPorControleFinanceiro(@PathVariable("id") Long id) throws Exception {
    	return receitaService.listarReceitaPorControleFinanceiro(id);
    }
	
	
}
