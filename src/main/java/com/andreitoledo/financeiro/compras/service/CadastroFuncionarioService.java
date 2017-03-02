package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.FuncionarioDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.Funcionario;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;


public class CadastroFuncionarioService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FuncionarioDAO funcionarioDAO;
	
	@Transactional
	public void salvar(Funcionario funcionario)throws NegocioException{
		if(funcionario.getNome() == null
				|| funcionario.getNome().trim().equals("")){
			
			throw new NegocioException("O nome é obrigatório !");
			
		}
		
		this.funcionarioDAO.salvar(funcionario);
		
	}
	

}
