package com.andreitoledo.financeiro.compras.controller.cadastros.produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.ProdutoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.Produto;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	ProdutoDAO produtoDAO;

	private List<Produto> produtos = new ArrayList<>();

	private Produto produtoSelecionado;
	
	@Inject
	private FacesMessages facesMessages;

	public List<Produto> getProdutos() {
		return produtos;
	}

	@PostConstruct
	public void inicializar() {
		produtos = produtoDAO.buscarTodos();
	}

	public void excluir() {
		try {
			produtoDAO.excluir(produtoSelecionado);
			this.produtos.remove(produtoSelecionado);
			facesMessages.info("Produto "
					+ produtoSelecionado.getDescricao()
					+ " excluído com sucesso !");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

}
