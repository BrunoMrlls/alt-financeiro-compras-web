package com.andreitoledo.financeiro.compras.controller.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.TipoObjetoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.TipoObjeto;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaTipoObjetoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	TipoObjetoDAO tipoObjetoDAO; 
	
	private List<TipoObjeto> tiposObjetos = new ArrayList<>();
	
	private TipoObjeto tipoObjetoSelecionado;
	
	@Inject
	private FacesMessages facesMessages;
	
	public List<TipoObjeto> getTiposObjetos(){
		return tiposObjetos;
	}
	
	@PostConstruct
	public void inicializar(){
		tiposObjetos = tipoObjetoDAO.buscarTodos();		
	}
	
	public void excluir(){
		try {
			tipoObjetoDAO.excluir(tipoObjetoSelecionado);
			this.tiposObjetos.remove(tipoObjetoSelecionado);
			facesMessages.info("Tipo Objeto "
					+ tipoObjetoSelecionado.getDescricao()
					+ " excluído com sucesso !");
			
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public TipoObjeto getTipoObjetoSelecionado() {
		return tipoObjetoSelecionado;
	}

	public void setTipoObjetoSelecionado(TipoObjeto tipoObjetoSelecionado) {
		this.tipoObjetoSelecionado = tipoObjetoSelecionado;
	}
	

}
