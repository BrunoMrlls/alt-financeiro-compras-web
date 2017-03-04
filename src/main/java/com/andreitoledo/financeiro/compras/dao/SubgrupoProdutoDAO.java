package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.financeiro.compras.model.cadastros.produto.SubgrupoProduto;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class SubgrupoProdutoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public SubgrupoProduto buscarPeloCodigo(Long codigo) {
		return manager.find(SubgrupoProduto.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<SubgrupoProduto> buscarTodos() {
		return manager.createQuery("select sp from SubgrupoProduto sp")
				.getResultList();
	}

	public void salvar(SubgrupoProduto subgrupoProduto) {
		manager.merge(subgrupoProduto);
	}

	@Transactional
	public void excluir(SubgrupoProduto subgrupoProduto)
			throws NegocioException {
		subgrupoProduto = buscarPeloCodigo(subgrupoProduto.getCodigo());
		try {
			manager.remove(subgrupoProduto);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException(
					"Este subgrupo de produto não pode ser excluído !");

		}
	}

}
