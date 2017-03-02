package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.financeiro.compras.model.cadastros.entidade.Funcionario;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class FuncionarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Funcionario buscarPeloCodigo(Long codigo) {
		return manager.find(Funcionario.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> buscarTodos() {
		return manager.createQuery("select f from Funcionario f")
				.getResultList();
	}

	public void salvar(Funcionario funcionario) {
		manager.merge(funcionario);
	}

	@Transactional
	public void excluir(Funcionario funcionario) throws NegocioException {
		funcionario = buscarPeloCodigo(funcionario.getCodigo());
		try {
			manager.remove(funcionario);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Funcionário não pode ser excluído !");
		}

	}

}
