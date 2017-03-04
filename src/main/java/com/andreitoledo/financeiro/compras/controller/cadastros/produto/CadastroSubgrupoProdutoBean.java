package com.andreitoledo.financeiro.compras.controller.cadastros.produto;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.model.cadastros.produto.SubgrupoProduto;
import com.andreitoledo.financeiro.compras.service.CadastroSubgrupoProdutoService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroSubgrupoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroSubgrupoProdutoService cadastroSubgrupoProdutoService;

	private SubgrupoProduto subgrupoProduto;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (subgrupoProduto == null) {

			limpar();

		}
	}

	public void limpar() {
		this.subgrupoProduto = new SubgrupoProduto();
	}

	public void salvar() {
		try {
			this.cadastroSubgrupoProdutoService.salvar(subgrupoProduto);
			facesMessages.info("Subgrupo Produto salvo com sucesso !");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public SubgrupoProduto getSubgrupoProduto() {
		return subgrupoProduto;
	}

	public void setSubgrupoProduto(SubgrupoProduto subgrupoProduto) {
		this.subgrupoProduto = subgrupoProduto;
	}

	public boolean isEditando() {
		return this.subgrupoProduto.getCodigo() != null;
	}

}
