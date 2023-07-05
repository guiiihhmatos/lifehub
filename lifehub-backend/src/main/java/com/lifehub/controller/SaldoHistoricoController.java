package com.lifehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifehub.models.controleFinanceiro.SaldoHistorico;
import com.lifehub.service.SaldoHistoricoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Historico do Saldo")
@RequestMapping("/historico")
public class SaldoHistoricoController {
	
	@Autowired
	private SaldoHistoricoService saldoHistoricoService;
	
	@GetMapping("/{id}")
	public List<SaldoHistorico> listarTodosOsHistoricosPorControleFinanceiro(@PathVariable("id") Long id)
	{
		return saldoHistoricoService.listarHistoricoPorControleFinanceiro(id);
	}
}
