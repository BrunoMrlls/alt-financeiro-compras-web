package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.EmpresaUsuariaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.EmpresaUsuaria;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CadastroEmpresaUsuariaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaUsuariaDAO empresaUsuariaDAO;
	
	@Transactional
	public void salvar(EmpresaUsuaria empresaUsuaria)throws NegocioException{
		if(empresaUsuaria.getNome() == null
				|| empresaUsuaria.getNome().trim().equals("")){			
			
			throw new NegocioException("O nome é obrigatório !");
			
		}
		
		this.empresaUsuariaDAO.salvar(empresaUsuaria);
	}

}
