package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.UsuarioDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.Usuario;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CadastroUsuarioService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	UsuarioDAO usuarioDAO;
	
	@Transactional
	public void salvar(Usuario usuario) throws NegocioException{
		if(usuario.getNome() == null
				|| usuario.getNome().trim().equals("")){
			throw new NegocioException("O nome do usuário é obrigatório !");
			
		}
		
		this.usuarioDAO.salvar(usuario);
	}

}
