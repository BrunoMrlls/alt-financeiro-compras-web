package com.andreitoledo.financeiro.compras.controller.cadastros.produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.SecaoProdutoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.SecaoProduto;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaSecaoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	SecaoProdutoDAO secaoProdutoDAO;

	private List<SecaoProduto> secaoProdutos = new ArrayList<>();

	private SecaoProduto secaoProdutoSelecionado;
	
	@Inject
	private FacesMessages facesMessages;

	public List<SecaoProduto> getSecaoProdutos() {
		return secaoProdutos;
	}

	@PostConstruct
	public void inicializar() {
		this.secaoProdutos = secaoProdutoDAO.buscarTodos();
	}

	public void excluir() {
		try {
			secaoProdutoDAO.excluir(secaoProdutoSelecionado);
			this.secaoProdutos.remove(secaoProdutoSelecionado);
			facesMessages.info("Secao Produto "
					+ secaoProdutoSelecionado.getDescricao()
					+ " excluído com sucesso !");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

	}

	public SecaoProduto getSecaoProdutoSelecionado() {
		return secaoProdutoSelecionado;
	}

	public void setSecaoProdutoSelecionado(SecaoProduto secaoProdutoSelecionado) {
		this.secaoProdutoSelecionado = secaoProdutoSelecionado;
	}
}
