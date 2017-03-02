package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.PessoaFisicaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.PessoaFisica;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CadastroPessoaFisicaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	PessoaFisicaDAO pessoaFisicaDAO;
	
	@Transactional
	public void salvar(PessoaFisica pessoaFisica)throws NegocioException{
		if(pessoaFisica.getNome() == null
				|| pessoaFisica.getNome().trim().equals("")){			
				throw new NegocioException("O nome da pessoa física é obrigatório !");
				
		}
		
		this.pessoaFisicaDAO.salvar(pessoaFisica);
		
		
	}

}
