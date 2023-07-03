package com.lifehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lifehub.models.controleFinanceiro.ControleFinanceiro;
import com.lifehub.service.ControleFinanceiroService;

@RestController
@RequestMapping("/controle-financeiro")
public class ControleFinanceiroController {
	
	@Autowired
    private ControleFinanceiroService controleFinanceiroService;

	@GetMapping
	public List<ControleFinanceiro> getAllControleiro()
	{	
		return controleFinanceiroService.listarControle();
	}
	
}
