package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.FamiliaProdutoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.FamiliaProduto;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CadastroFamiliaProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FamiliaProdutoDAO familiaProdutoDAO;

	@Transactional
	public void salvar(FamiliaProduto familiaProduto) throws NegocioException {

		if (familiaProduto.getDescricao() == null
				|| familiaProduto.getDescricao().trim().equals("")) {
			throw new NegocioException("A descrição é obrigatório !");

		}

		this.familiaProdutoDAO.salvar(familiaProduto);

	}

}
