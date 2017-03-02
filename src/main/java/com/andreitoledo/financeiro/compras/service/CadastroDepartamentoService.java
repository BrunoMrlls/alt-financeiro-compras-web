package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.DepartamentoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.Departamento;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CadastroDepartamentoService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	DepartamentoDAO departamentoDAO;
	
	@Transactional
	public void salvar(Departamento departamento) throws NegocioException{
		if(departamento.getNome() == null
				|| departamento.getNome().trim().equals("")){
			throw new NegocioException("O nome do departameno é obrigatório !");
			
		}
		
		this.departamentoDAO.salvar(departamento);
		
	}

}
