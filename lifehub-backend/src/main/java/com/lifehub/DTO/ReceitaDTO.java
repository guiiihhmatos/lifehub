package com.lifehub.DTO;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.lifehub.models.controleFinanceiro.Receita;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReceitaDTO {
	
	private String descricao;
	private BigDecimal valor;
	private Date data;
	private Long id_controleFinanceiro;

	public ReceitaDTO(Receita receita) {
		BeanUtils.copyProperties(receita, this);
	}
}
