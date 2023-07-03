package com.lifehub.DTO;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DespesaDTO {
	
	private String descricao;
    private BigDecimal valor;
    private Date data;
    private Long id_controleFinanceiro;
}
