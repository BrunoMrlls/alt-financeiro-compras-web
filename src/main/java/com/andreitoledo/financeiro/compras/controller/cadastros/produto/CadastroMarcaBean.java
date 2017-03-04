package com.andreitoledo.financeiro.compras.controller.cadastros.produto;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.model.cadastros.produto.Marca;
import com.andreitoledo.financeiro.compras.service.CadastroMarcaService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroMarcaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroMarcaService cadastroMarcaService;

	private Marca marca;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (marca == null) {
			limpar();
		}
	}

	public void limpar() {
		this.marca = new Marca();
	}

	public void salvar() {
		try {
			cadastroMarcaService.salvar(marca);
			facesMessages.info("Marca salvo com sucesso !");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}

	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	public boolean isEditando(){
		return this.marca.getCodigo() != null;
	}

}
