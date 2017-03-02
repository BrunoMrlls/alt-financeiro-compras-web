package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.financeiro.compras.model.cadastros.entidade.Vendedor;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class VendedorDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Vendedor buscarPeloCodigo(Long codigo) {
		return manager.find(Vendedor.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Vendedor> buscarTodos() {
		return manager.createNamedQuery("Vendedor.buscarTodos").getResultList();
	}

	public void salvar(Vendedor vendedor) {
		manager.merge(vendedor);
	}

	@Transactional
	public void excluir(Vendedor vendedor) throws NegocioException {
		vendedor = buscarPeloCodigo(vendedor.getCodigo());
		try {
			manager.remove(vendedor);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Esse vendedor não pode ser excluído !");

		}

	}

}
