package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.GrupoProdutoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.GrupoProduto;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CadastroGrupoProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GrupoProdutoDAO grupoProdutoDAO;

	@Transactional
	public void salvar(GrupoProduto grupoProduto) throws NegocioException {
		if (grupoProduto.getDescricao() == null
				|| grupoProduto.getDescricao().trim().equals("")) {
			throw new NegocioException("A descrição é obrigatória !");

		}

		this.grupoProdutoDAO.salvar(grupoProduto);

	}

}
