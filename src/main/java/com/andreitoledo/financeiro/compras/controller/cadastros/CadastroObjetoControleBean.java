package com.andreitoledo.financeiro.compras.controller.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.TipoObjetoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.ObjetoControle;
import com.andreitoledo.financeiro.compras.model.cadastros.TipoObjeto;
import com.andreitoledo.financeiro.compras.service.CadastroObjetoControleService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroObjetoControleBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroObjetoControleService cadastroObjetoControleService;
	
	private ObjetoControle objetoControle;
	
	private List<TipoObjeto> tiposObjetos;
	
	@Inject
	private TipoObjetoDAO tipoObjetoDAO;
	
	@Inject
	private FacesMessages facesMessages; 
	
	public void inicializar(){
		if(this.objetoControle == null){
			limpar();
			
		}
		
		this.tiposObjetos = this.tipoObjetoDAO.buscarTodos();
	}
	
	public void limpar(){
		this.objetoControle = new ObjetoControle();
	}
	
	public void salvar(){
		try {
			this.cadastroObjetoControleService.salvar(objetoControle);
			facesMessages.info("Objeto controle salvo com sucesso !");
			
			limpar();
			
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public ObjetoControle getObjetoControle() {
		return objetoControle;
	}

	public void setObjetoControle(ObjetoControle objetoControle) {
		this.objetoControle = objetoControle;
	}
	
	public List<TipoObjeto> getTiposObjetos() {
		return tiposObjetos;
	}

	public boolean isEditando(){
		return this.objetoControle.getCodigo() != null;
	}
	
	

}
