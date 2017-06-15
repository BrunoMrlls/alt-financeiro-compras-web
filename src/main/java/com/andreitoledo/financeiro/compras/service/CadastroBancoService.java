package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.BancoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.Banco;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CadastroBancoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private BancoDAO bancoDAO;

	@Transactional
	public void salvar(Banco banco) throws NegocioException {
		if (banco.getNome() == null || banco.getNome().trim().equals("")) {
			throw new NegocioException("O nome do banco é obrigatório.");

		}

		this.bancoDAO.salvar(banco);
	}

}
