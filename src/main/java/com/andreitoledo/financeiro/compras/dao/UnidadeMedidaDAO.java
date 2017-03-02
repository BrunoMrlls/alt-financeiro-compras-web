package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.financeiro.compras.model.cadastros.produto.UnidadeMedida;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class UnidadeMedidaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public UnidadeMedida buscarPeloCodigo(Long codigo) {
		return manager.find(UnidadeMedida.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<UnidadeMedida> buscarTodos() {
		return manager.createNamedQuery("UnidadeMedida.buscarTodos").getResultList();
	}

	public void salvar(UnidadeMedida unidadeMedida) {
		manager.merge(unidadeMedida);
	}

	@Transactional
	public void excluir(UnidadeMedida unidadeMedida) throws NegocioException {
		unidadeMedida = buscarPeloCodigo(unidadeMedida.getCodigo());
		try {
			manager.remove(unidadeMedida);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException(
					"Esta Unidade de Medida não pode ser excluída !");

		}

	}

}
