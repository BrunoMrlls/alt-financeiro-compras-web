package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.financeiro.compras.model.cadastros.Banco;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class BancoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Banco buscarPeloCodigo(Long codigo) {
		return manager.find(Banco.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Banco> buscarTodos() {
		return manager.createNamedQuery("Banco.buscarTodos").getResultList();
	}
	
	public void salvar(Banco banco){
		manager.merge(banco);
	}

	@Transactional
	public void excluir(Banco banco) throws NegocioException {
		banco = buscarPeloCodigo(banco.getCodigo());
		try {
			manager.remove(banco);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Este banco não pode ser excluído.");

		}
	}

}
