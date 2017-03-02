package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.financeiro.compras.model.cadastros.entidade.OutroCredor;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class OutroCredorDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public OutroCredor buscarPeloCodigo(Long codigo) {
		return manager.find(OutroCredor.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<OutroCredor> buscarTodos() {
		return manager.createQuery("select oc from OutroCredor oc")
				.getResultList();
	}

	public void salvar(OutroCredor outroCredor) {
		manager.merge(outroCredor);
	}

	@Transactional
	public void excluir(OutroCredor outroCredor) throws NegocioException {
		outroCredor = buscarPeloCodigo(outroCredor.getCodigo());
		try {
			manager.remove(outroCredor);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException(
					"Este Outro Credor não pode ser excluído !");

		}
	}

}
