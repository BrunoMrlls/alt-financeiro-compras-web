package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.andreitoledo.financeiro.compras.model.cadastros.entidade.Entidade;

public class EntidadeDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public List<Entidade> buscarTodos(){
		return manager.createQuery("from Entidade").getResultList();		
	}

}
