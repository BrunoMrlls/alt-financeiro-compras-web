package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.MarcaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.Marca;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CadastroMarcaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private MarcaDAO marcaDAO;

	@Transactional
	public void salvar(Marca marca) throws NegocioException {
		if (marca.getDescricao() == null
				|| marca.getDescricao().trim().equals("")) {

			throw new NegocioException("A descrição é obrigatoria !");

		}
		this.marcaDAO.salvar(marca);
	}

}
