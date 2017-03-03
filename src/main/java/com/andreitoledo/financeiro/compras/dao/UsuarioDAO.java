package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.financeiro.compras.model.cadastros.Usuario;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class UsuarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Usuario buscarPeloCodigo(Long codigo) {
		return manager.find(Usuario.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> buscarTodos() {
		return manager.createNamedQuery("Usuario.buscarTodos").getResultList();
	}

	public void salvar(Usuario usuario) {
		manager.merge(usuario);
	}

	@Transactional
	public void excluir(Usuario usuario) throws NegocioException {
		usuario = buscarPeloCodigo(usuario.getCodigo());
		try {
			manager.remove(usuario);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Este usuário não pode ser excluido !");
		}
	}

}
