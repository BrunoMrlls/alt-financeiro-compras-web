package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.financeiro.compras.model.cadastros.TipoObjeto;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class TipoObjetoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public TipoObjeto buscarPeloCodigo(Long codigo) {
		return manager.find(TipoObjeto.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<TipoObjeto> buscarTodos() {
		return manager.createQuery("select to from TipoObjeto to")
				.getResultList();
	}

	public void salvar(TipoObjeto tipoObjeto) {
		manager.merge(tipoObjeto);
	}

	@Transactional
	public void excluir(TipoObjeto tipoObjeto) throws NegocioException {
		tipoObjeto = buscarPeloCodigo(tipoObjeto.getCodigo());
		try {
			manager.remove(tipoObjeto);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException(
					"Este Objeto Controle não pode ser excluído !");

		}

	}

}
