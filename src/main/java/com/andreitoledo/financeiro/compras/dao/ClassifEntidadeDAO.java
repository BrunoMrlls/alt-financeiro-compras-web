package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.financeiro.compras.model.cadastros.entidade.ClassifEntidade;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class ClassifEntidadeDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public ClassifEntidade buscarPeloCodigo(Long codigo) {
		return manager.find(ClassifEntidade.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<ClassifEntidade> buscarTodos() {
		return manager.createQuery("select ce from ClassifEntidade ce")
				.getResultList();
	}

	public void salvar(ClassifEntidade classifEntidade) {
		manager.merge(classifEntidade);
	}

	@Transactional
	public void excluir(ClassifEntidade classifEntidade)
			throws NegocioException {
		classifEntidade = buscarPeloCodigo(classifEntidade.getCodigo());
		try {
			manager.remove(classifEntidade);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Classificação não pode ser excluída !");

		}

	}

}
