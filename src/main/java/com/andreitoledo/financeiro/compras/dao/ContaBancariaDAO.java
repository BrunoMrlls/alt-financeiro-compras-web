package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.financeiro.compras.model.cadastros.ContaBancaria;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class ContaBancariaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public ContaBancaria buscarPeloCodigo(Long codigo) {
		return manager.find(ContaBancaria.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<ContaBancaria> buscarTodos() {
		return manager.createNamedQuery("ContaBancaria.buscarTodos")
				.getResultList();
	}

	public void salvar(ContaBancaria contaBancaria) {
		manager.merge(contaBancaria);
	}

	@Transactional
	public void excluir(ContaBancaria contaBancaria) throws NegocioException {
		contaBancaria = buscarPeloCodigo(contaBancaria.getCodigo());
		try {
			manager.remove(contaBancaria);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Esta conta não pode ser excluída.");

		}
	}

}
