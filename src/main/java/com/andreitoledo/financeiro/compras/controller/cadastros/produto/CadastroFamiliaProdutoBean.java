package com.andreitoledo.financeiro.compras.controller.cadastros.produto;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.model.cadastros.produto.FamiliaProduto;
import com.andreitoledo.financeiro.compras.service.CadastroFamiliaProdutoService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroFamiliaProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroFamiliaProdutoService cadastroFamiliaProdutoService;

	private FamiliaProduto familiaProduto;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (familiaProduto == null) {
			limpar();
		}
	}

	public void limpar() {
		this.familiaProduto = new FamiliaProduto();
	}

	public void salvar() {
		try {
			this.cadastroFamiliaProdutoService.salvar(familiaProduto);
			facesMessages.info("Familia Produto salvo com sucesso !");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

	}

	public FamiliaProduto getFamiliaProduto() {
		return familiaProduto;
	}

	public void setFamiliaProduto(FamiliaProduto familiaProduto) {
		this.familiaProduto = familiaProduto;
	}

	public boolean isEditando() {
		return this.familiaProduto.getCodigo() != null;
	}

}
