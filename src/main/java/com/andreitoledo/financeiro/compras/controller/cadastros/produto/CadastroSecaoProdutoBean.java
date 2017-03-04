package com.andreitoledo.financeiro.compras.controller.cadastros.produto;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.model.cadastros.produto.SecaoProduto;
import com.andreitoledo.financeiro.compras.service.CadastroSecaoProdutoService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroSecaoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroSecaoProdutoService cadastroSecaoProdutoService;

	private SecaoProduto secaoProduto;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (secaoProduto == null) {
			limpar();
		}
	}

	public void limpar() {
		this.secaoProduto = new SecaoProduto();
	}

	public void salvar() {
		try {
			this.cadastroSecaoProdutoService.salvar(secaoProduto);
			facesMessages.info("Seção de Produto salvo com sucesso !");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

	}

	public SecaoProduto getSecaoProduto() {
		return secaoProduto;
	}

	public void setSecaoProduto(SecaoProduto secaoProduto) {
		this.secaoProduto = secaoProduto;
	}

	public boolean isEditando() {
		return this.secaoProduto.getCodigo() != null;
	}

}
