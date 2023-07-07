package com.lifehub.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lifehub.DTO.UsuarioRequestDTO;
import com.lifehub.exception.emailJaCadastradoException;
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

	@Transactional
	public Usuario salvarUsuario(UsuarioRequestDTO requestDTO)
	{
		Usuario usuario = new Usuario();
        usuario.setNome(requestDTO.getNome());
        usuario.setTelefone(requestDTO.getTelefone());
        usuario.setEmail(requestDTO.getEmail());
        usuario.setSenha(requestDTO.getSenha());

        ControleFinanceiro controleFinanceiro = new ControleFinanceiro();
        controleFinanceiro.setSaldo(BigDecimal.ZERO);
        
		usuarioRepository.save(usuario);
        controleFinanceiro.setUsuario(usuario);
        controleFinanceiroRepository.save(controleFinanceiro);
        usuario.setControleFinanceiro(controleFinanceiro);
        
        return usuario;
	}
	
	@Transactional(readOnly = true)
	public List<Usuario> listarUsuarios()
	{
		
		return usuarioRepository.findAll();
	}
	
	@Transactional
	public Optional<Usuario> emailExists(UsuarioRequestDTO usuarioRequestDTO) throws emailJaCadastradoException
	{
		return Optional.ofNullable(usuarioRepository.findByEmail(usuarioRequestDTO.getEmail()));
	}
}
