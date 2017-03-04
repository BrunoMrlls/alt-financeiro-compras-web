package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.financeiro.compras.model.cadastros.produto.FamiliaProduto;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class FamiliaProdutoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public FamiliaProduto buscarPeloCodigo(Long codigo) {
		return manager.find(FamiliaProduto.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<FamiliaProduto> buscarTodos() {
		return manager.createQuery("select fp from FamiliaProduto fp")
				.getResultList();
	}

	public void salvar(FamiliaProduto familiaProduto) {
		manager.merge(familiaProduto);
	}

	@Transactional
	public void excluir(FamiliaProduto familiaProduto) throws NegocioException {
		familiaProduto = buscarPeloCodigo(familiaProduto.getCodigo());
		try {
			manager.remove(familiaProduto);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException(
					"Esta Familia Produto não pode ser excluído !");

		}

	}

}
