package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.ObjetoControleDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.ObjetoControle;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CadastroObjetoControleService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ObjetoControleDAO objetoControleDAO;
	
	@Transactional
	public void salvar(ObjetoControle objetoControle)throws NegocioException{
		if(objetoControle.getDescricao() == null
				|| objetoControle.getDescricao().trim().equals("")){
			
			throw new NegocioException("O nome é obrigatório !");
			
		}
		
		this.objetoControleDAO.salvar(objetoControle);
	}

}
