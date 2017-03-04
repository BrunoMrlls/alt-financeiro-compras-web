package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.financeiro.compras.model.cadastros.produto.Marca;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class MarcaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Marca buscarPeloCodigo(Long codigo) {
		return manager.find(Marca.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Marca> buscarTodos() {
		return manager.createQuery("select m from Marca m").getResultList();
	}

	public void salvar(Marca marca) {
		manager.merge(marca);
	}

	@Transactional
	public void excluir(Marca marca) throws NegocioException {
		marca = buscarPeloCodigo(marca.getCodigo());
		try {
			manager.remove(marca);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Esta marca não pode ser excluída !");

		}

	}

}
