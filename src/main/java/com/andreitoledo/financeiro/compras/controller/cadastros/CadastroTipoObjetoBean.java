package com.andreitoledo.financeiro.compras.controller.cadastros;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.model.cadastros.TipoObjeto;
import com.andreitoledo.financeiro.compras.service.CadastroTipoObjetoService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroTipoObjetoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroTipoObjetoService cadastroTipoObjetoService;
	
	private TipoObjeto tipoObjeto; 
	
	@Inject
	private FacesMessages facesMessages;
	
	public void inicializar(){
		if(this.tipoObjeto == null){
			limpar();
			
		}
	}

	private void limpar() {
		this.tipoObjeto = new TipoObjeto();
		
	}
	
	public void salvar(){
		try {
			this.cadastroTipoObjetoService.salvar(tipoObjeto);
			facesMessages.info("Tipo Objeto salvo com sucesso !");
			
			limpar();
			
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
		
	}

	public TipoObjeto getTipoObjeto() {
		return tipoObjeto;
	}

	public void setTipoObjeto(TipoObjeto tipoObjeto) {
		this.tipoObjeto = tipoObjeto;
	}
	
	public boolean isEditando(){
		return this.tipoObjeto.getCodigo() != null;
	}
	

}
