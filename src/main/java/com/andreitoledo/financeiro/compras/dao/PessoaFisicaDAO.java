package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.financeiro.compras.model.cadastros.entidade.PessoaFisica;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class PessoaFisicaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public PessoaFisica buscarPeloCodigo(Long codigo) {
		return manager.find(PessoaFisica.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<PessoaFisica> buscarTodos() {
		return manager.createNamedQuery("PessoaFisica.buscarTodos")
				.getResultList();
	}

	public void salvar(PessoaFisica pessoaFisica) {
		manager.merge(pessoaFisica);
	}

	@Transactional
	public void excluir(PessoaFisica pessoaFisica) throws NegocioException {
		pessoaFisica = buscarPeloCodigo(pessoaFisica.getCodigo());
		try {
			manager.remove(pessoaFisica);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException(
					"Esta pessoa fisica não pode ser excluído !");

		}
	}

}
