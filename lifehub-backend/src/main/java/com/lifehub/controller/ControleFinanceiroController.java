package com.lifehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lifehub.models.controleFinanceiro.ControleFinanceiro;
import com.lifehub.service.ControleFinanceiroService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Controle Financeiro")
@RequestMapping("/controle-financeiro")
public class ControleFinanceiroController {
	
	@Autowired
    private ControleFinanceiroService controleFinanceiroService;

	@GetMapping
	public List<ControleFinanceiro> getAllControleiro() throws Exception{	
		return controleFinanceiroService.listarControle();
	}
	
}
