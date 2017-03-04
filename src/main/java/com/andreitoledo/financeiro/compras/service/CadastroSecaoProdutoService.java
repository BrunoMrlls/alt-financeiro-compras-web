package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.SecaoProdutoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.SecaoProduto;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CadastroSecaoProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	SecaoProdutoDAO secaoProdutoDAO;

	@Transactional
	public void salvar(SecaoProduto secaoProduto) throws NegocioException {
		if (secaoProduto.getDescricao() == null
				|| secaoProduto.getDescricao().trim().equals("")) {
			throw new NegocioException("A descrição é obrigatória !");

		}

		this.secaoProdutoDAO.salvar(secaoProduto);
	}

}
