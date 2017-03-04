package com.andreitoledo.financeiro.compras.controller.cadastros.produto;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.model.cadastros.produto.GrupoProduto;
import com.andreitoledo.financeiro.compras.service.CadastroGrupoProdutoService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroGrupoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroGrupoProdutoService cadastroGrupoProdutoService;

	private GrupoProduto grupoProduto;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (grupoProduto == null) {
			limpar();

		}
	}

	public void limpar() {
		this.grupoProduto = new GrupoProduto();
	}

	public void salvar() {
		try {
			this.cadastroGrupoProdutoService.salvar(grupoProduto);
			facesMessages.info("Grupo Produto salvo com sucesso !");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public GrupoProduto getGrupoProduto() {
		return grupoProduto;
	}

	public void setGrupoProduto(GrupoProduto grupoProduto) {
		this.grupoProduto = grupoProduto;
	}

	public boolean isEditando() {
		return this.grupoProduto.getCodigo() != null;
	}

}
