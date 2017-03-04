package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.SubgrupoProdutoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.SubgrupoProduto;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CadastroSubgrupoProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SubgrupoProdutoDAO subgrupoProdutoDAO;

	@Transactional
	public void salvar(SubgrupoProduto subgrupoProduto) throws NegocioException {

		if (subgrupoProduto.getDescricao() == null
				|| subgrupoProduto.getDescricao().trim().equals("")) {

			throw new NegocioException("A descrição é obrigatoria !");

		}

		this.subgrupoProdutoDAO.salvar(subgrupoProduto);
	}

}
