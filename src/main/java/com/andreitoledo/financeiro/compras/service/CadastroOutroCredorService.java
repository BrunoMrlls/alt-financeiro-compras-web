package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.OutroCredorDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.OutroCredor;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CadastroOutroCredorService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	OutroCredorDAO outroCredorDAO;

	@Transactional
	public void salvar(OutroCredor outroCredor) throws NegocioException {
		if (outroCredor.getNome() == null
				|| outroCredor.getNome().trim().equals("")) {
			throw new NegocioException("O nome do outro credor é obrigatório !");

		}

		this.outroCredorDAO.salvar(outroCredor);
	}

}
