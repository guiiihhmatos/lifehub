package com.lifehub.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lifehub.models.controleFinanceiro.ControleFinanceiro;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String telefone;
	
	private String email;
	private String senha;
	
	
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnore
    private ControleFinanceiro controleFinanceiro;

    //@OneToMany(mappedBy = "usuario")
    //private List<Tarefa> tarefas;
	
}
