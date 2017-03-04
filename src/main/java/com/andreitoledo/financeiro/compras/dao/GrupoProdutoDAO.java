package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.financeiro.compras.model.cadastros.produto.GrupoProduto;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class GrupoProdutoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public GrupoProduto buscarPeloCodigo(Long codigo) {
		return manager.find(GrupoProduto.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<GrupoProduto> buscarTodos() {
		return manager.createQuery("select gp from GrupoProduto gp")
				.getResultList();
	}

	public void salvar(GrupoProduto grupoProduto) {
		manager.merge(grupoProduto);
	}

	@Transactional
	public void excluir(GrupoProduto grupoProduto) throws NegocioException {
		grupoProduto = buscarPeloCodigo(grupoProduto.getCodigo());
		try {
			manager.remove(grupoProduto);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException(
					"Este grupo de produto não pode ser exluido !");

		}

	}

}
