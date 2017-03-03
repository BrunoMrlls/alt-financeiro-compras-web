package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.financeiro.compras.model.cadastros.ObjetoControle;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class ObjetoControleDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public ObjetoControle buscarPeloCodigo(Long codigo) {
		return manager.find(ObjetoControle.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<ObjetoControle> buscarTodos() {
		return manager.createNamedQuery("ObjetoControle.buscarTodos")
				.getResultList();
	}

	public void salvar(ObjetoControle objetoControle) {
		manager.merge(objetoControle);
	}

	@Transactional
	public void excluir(ObjetoControle objetoControle) throws NegocioException {
		objetoControle = buscarPeloCodigo(objetoControle.getCodigo());
		try {
			manager.remove(objetoControle);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException(
					"Este objeto controle não pode ser excluído !");
		}

	}

}
