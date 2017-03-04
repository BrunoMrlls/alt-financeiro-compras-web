package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.financeiro.compras.model.cadastros.produto.Produto;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class ProdutoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Produto buscarPeloCodigo(Long codigo) {
		return manager.find(Produto.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Produto> buscarTodos() {
		return manager.createNamedQuery("Produto.buscarTodos").getResultList();
	}

	public void salvar(Produto produto) {
		manager.merge(produto);
	}

	@Transactional
	public void excluir(Produto produto) throws NegocioException {
		produto = buscarPeloCodigo(produto.getCodigo());
		try {
			manager.remove(produto);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Este Produto não pode ser excluído !");

		}

	}

	public List<Produto> porDescricaoSemelhante(String descricao) {

		return manager
				.createQuery("from Produto where descricao like :descricao",
						Produto.class)
				.setParameter("descricao", "%" + descricao + "%")
				.getResultList();

	}

	public List<Produto> porDescricao(String descricao) {
		return this.manager
				.createQuery(
						"from Produto where upper(descricao) like :descricao",
						Produto.class)
				.setParameter("descricao", descricao.toUpperCase() + "%")
				.getResultList();

	}

}
