package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.TipoObjetoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.TipoObjeto;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CadastroTipoObjetoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoObjetoDAO tipoObjetoDAO;

	@Transactional
	public void salvar(TipoObjeto tipoObjeto) throws NegocioException {
		
		if (tipoObjeto.getDescricao() == null
				|| tipoObjeto.getDescricao().trim().equals("")) {
			
			throw new NegocioException("A descrição é obrigatória !");

		}

		this.tipoObjetoDAO.salvar(tipoObjeto);

	}	
	

}
