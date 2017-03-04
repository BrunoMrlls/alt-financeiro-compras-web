package com.andreitoledo.financeiro.compras.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.andreitoledo.financeiro.compras.dao.ProdutoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.Produto;

@Named
@ViewScoped
public class SelecaoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoDAO produtoDAO;

	private String descricao;

	private List<Produto> produtosFiltrados;

	public void pesquisar() {
		produtosFiltrados = produtoDAO.porDescricaoSemelhante(descricao);
	}

	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 470);

		RequestContext.getCurrentInstance().openDialog("SelecaoProduto",
				opcoes, null);
	}

	public void selecionar(Produto produto) {
		RequestContext.getCurrentInstance().closeDialog(produto);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

}