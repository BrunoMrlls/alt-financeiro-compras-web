package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.ContaBancariaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.ContaBancaria;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CadastroContaBancariaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ContaBancariaDAO contaBancariaDAO;
	
	@Transactional
	public void salvar(ContaBancaria contaBancaria) throws NegocioException {
		if (contaBancaria.getDescricao() == null || contaBancaria.getDescricao().trim().equals("")) {
			throw new NegocioException("A descrição é obrigatório.");
			
		}
		
		this.contaBancariaDAO.salvar(contaBancaria);
	}

}
