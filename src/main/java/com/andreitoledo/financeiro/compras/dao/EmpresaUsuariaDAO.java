package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.financeiro.compras.model.cadastros.EmpresaUsuaria;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class EmpresaUsuariaDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public EmpresaUsuaria buscarPeloCodigo(Long codigo){
		return manager.find(EmpresaUsuaria.class, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public List<EmpresaUsuaria> buscarTodos(){
		return manager.createNamedQuery("EmpresaUsuaria.buscarTodos").getResultList();		
	}
	
	public void salvar(EmpresaUsuaria empresaUsuaria){
		manager.merge(empresaUsuaria);		
	}
	
	@Transactional
	public void excluir(EmpresaUsuaria empresaUsuaria) throws NegocioException{
		empresaUsuaria = buscarPeloCodigo(empresaUsuaria.getCodigo());
		try {
			manager.remove(empresaUsuaria);
			manager.flush();
			
		} catch (PersistenceException e) {
			throw new NegocioException("Esta empresa usuária não pode ser salva !");

		}
		
	}

}
