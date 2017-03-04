package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.ProdutoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.Produto;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CadastroProdutoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProdutoDAO ProdutoDAO;
	
	@Transactional
	public void salvar(Produto produto) throws NegocioException{	
		
		if(produto.getTipoSituacaoCadastro() == null
				|| produto.getTipoSituacaoCadastro().equals("Selecione")){
			throw new NegocioException("A situação do cadastro deve ser informado");
			
		}
		
		this.ProdutoDAO.salvar(produto);
		
	}

}
