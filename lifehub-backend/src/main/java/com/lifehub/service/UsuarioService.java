package com.lifehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.lifehub.models.Usuario;
import com.lifehub.models.controleFinanceiro.ControleFinanceiro;
import com.lifehub.repository.ControleFinanceiroRepository;
import com.lifehub.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ControleFinanceiroRepository controleFinanceiroRepository;

	public Usuario salvarUsuario(Usuario usuario, ControleFinanceiro controleFinanceiro)
	{
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
        controleFinanceiro.setUsuario(usuarioSalvo);
        controleFinanceiroRepository.save(controleFinanceiro);
        usuarioSalvo.setControleFinanceiro(controleFinanceiro);
        return usuarioSalvo;
	}
	
	public List<Usuario> listarUsuarios()
	{
		return usuarioRepository.findAll();
	}
}
