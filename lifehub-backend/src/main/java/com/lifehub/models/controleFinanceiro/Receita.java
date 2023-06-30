package com.lifehub.models.controleFinanceiro;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Receita {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    private String descricao;
    private BigDecimal valor;
    private Date data;

    @ManyToOne
    private ControleFinanceiro controleFinanceiro;


}
