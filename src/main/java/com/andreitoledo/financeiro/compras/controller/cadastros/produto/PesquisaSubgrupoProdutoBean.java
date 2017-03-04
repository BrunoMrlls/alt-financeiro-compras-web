package com.andreitoledo.financeiro.compras.controller.cadastros.produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.SubgrupoProdutoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.SubgrupoProduto;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaSubgrupoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<SubgrupoProduto> subgrupoProdutos = new ArrayList<>();

	@Inject
	SubgrupoProdutoDAO subgrupoProdutoDAO;

	private SubgrupoProduto subgrupoProdutoSelecionado;

	@Inject
	private FacesMessages facesMessages;

	public List<SubgrupoProduto> getSubgrupoProdutos() {
		return subgrupoProdutos;
	}

	@PostConstruct
	public void inicializar() {
		subgrupoProdutos = subgrupoProdutoDAO.buscarTodos();
	}

	public void excluir() {
		try {
			subgrupoProdutoDAO.excluir(subgrupoProdutoSelecionado);
			subgrupoProdutos.remove(subgrupoProdutoSelecionado);
			facesMessages.info("Subgrupo Produto "
					+ subgrupoProdutoSelecionado.getDescricao()
					+ " excluído com sucesso !");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

	}

	public SubgrupoProduto getSubgrupoProdutoSelecionado() {
		return subgrupoProdutoSelecionado;
	}

	public void setSubgrupoProdutoSelecionado(
			SubgrupoProduto subgrupoProdutoSelecionado) {
		this.subgrupoProdutoSelecionado = subgrupoProdutoSelecionado;
	}
}
