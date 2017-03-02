package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.VendedorDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.Vendedor;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CadastroVendedorService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	VendedorDAO vendedorDAO;

	@Transactional
	public void salvar(Vendedor vendedor) throws NegocioException {
		
		if (vendedor.getNome() == null || vendedor.getNome().trim().equals("")) {
			throw new NegocioException("O nome do vendedor é obrigatório !");

		}		

		if (vendedor.getFuncionario() == null) {
			throw new NegocioException("A entidade do vendedor é obrigatório !");

		}

		this.vendedorDAO.salvar(vendedor);
	}

}
