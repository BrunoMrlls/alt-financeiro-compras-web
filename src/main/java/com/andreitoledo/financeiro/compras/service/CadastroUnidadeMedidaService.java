package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.UnidadeMedidaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.UnidadeMedida;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;


public class CadastroUnidadeMedidaService implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private UnidadeMedidaDAO unidadeMedidaDAO;
	
	@Transactional
	public void salvar(UnidadeMedida unidadeMedida)throws NegocioException{
		
		if(unidadeMedida.getDescricao() == null || unidadeMedida.getDescricao().trim().equals("")){
			throw new NegocioException("A descrição é obrigatório !");
			
		}
		
		this.unidadeMedidaDAO.salvar(unidadeMedida);
		
	}

}
