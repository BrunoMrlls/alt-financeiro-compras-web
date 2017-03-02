package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.PessoaJuridicaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.PessoaJuridica;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CadastroPessoaJuridicaService implements Serializable{

	private static final long serialVersionUID = 1L;	
	
	@Inject
	private PessoaJuridicaDAO pessoaJuridicaDAO;
	
	@Transactional
	public void salvar(PessoaJuridica pessoaJuridica)throws NegocioException{
		this.pessoaJuridicaDAO.salvar(pessoaJuridica);
	} 

}
