package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.financeiro.compras.model.cadastros.Departamento;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class DepartamentoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Departamento buscarPeloCodigo(Long codigo) {
		return manager.find(Departamento.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Departamento> buscarTodos() {
		return manager.createNamedQuery("Departamento.buscarTodos").getResultList();
	}

	public void salvar(Departamento departamento) {
		manager.merge(departamento);
	}

	@Transactional
	public void excluir(Departamento departamento) throws NegocioException {
		departamento = buscarPeloCodigo(departamento.getCodigo());
		try {
			manager.remove(departamento);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException(
					"Este departamento não pode ser excluído !");

		}

	}

}
