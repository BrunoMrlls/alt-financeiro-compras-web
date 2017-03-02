package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.ClassifEntidadeDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.ClassifEntidade;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CadastroClassifEntidadeService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	ClassifEntidadeDAO classifEntidadeDAO;

	@Transactional
	public void salvar(ClassifEntidade classifEntidade) throws NegocioException {
		if (classifEntidade.getNome() == null
				|| classifEntidade.getNome().trim().equals("")) {
			throw new NegocioException("A descrição é obrigatório !");

		}
		this.classifEntidadeDAO.salvar(classifEntidade);
	}

}
