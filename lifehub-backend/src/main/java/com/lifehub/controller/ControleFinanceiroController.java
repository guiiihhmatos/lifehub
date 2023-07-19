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
	public List<ControleFinanceiro> getAllControleFinanceiro() throws Exception{	
		return controleFinanceiroService.listarControle();
	}
	
	@GetMapping("/{id}")
	public ControleFinanceiro getControleFinanceiroByID(@PathVariable("id") Long id) throws Exception{
		
		return controleFinanceiroService.findById(id);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ControleFinanceiro getControleFinanceiroByUsuarioID(@PathVariable("usuarioId") Long usuarioId) throws Exception{
		
		return controleFinanceiroService.findByIdUsuario(usuarioId);
	}
	
}
