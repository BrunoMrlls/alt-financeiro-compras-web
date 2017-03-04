package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.financeiro.compras.model.cadastros.produto.SecaoProduto;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class SecaoProdutoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public SecaoProduto buscarPeloCodigo(Long codigo) {
		return manager.find(SecaoProduto.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<SecaoProduto> buscarTodos() {
		return manager.createQuery("select sp from SecaoProduto sp")
				.getResultList();
	}

	public void salvar(SecaoProduto secaoProduto) {
		manager.merge(secaoProduto);
	}

	@Transactional
	public void excluir(SecaoProduto secaoProduto) throws NegocioException {
		secaoProduto = buscarPeloCodigo(secaoProduto.getCodigo());
		try {
			manager.remove(secaoProduto);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException(
					"Essa Seção de Produto não pode ser excluído !");
		}

	}

}
