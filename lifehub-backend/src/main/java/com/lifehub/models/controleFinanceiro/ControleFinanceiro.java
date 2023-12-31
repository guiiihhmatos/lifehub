package com.lifehub.models.controleFinanceiro;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lifehub.models.usuario.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_controle_financeiro")
public class ControleFinanceiro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "usuario_id")
	@JsonIgnore
	private Usuario usuario;
	
	private BigDecimal saldo;
	
	
}
