package com.andreitoledo.financeiro.compras.controller.cadastros.produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.GrupoProdutoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.GrupoProduto;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaGrupoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<GrupoProduto> grupoProdutos = new ArrayList<>();

	@Inject
	GrupoProdutoDAO grupoProdutoDAO;

	private GrupoProduto grupoProdutoSelecionado;

	@Inject
	private FacesMessages facesMessages;

	public List<GrupoProduto> getGrupoProdutos() {
		return grupoProdutos;
	}

	@PostConstruct
	public void inicializar() {
		grupoProdutos = grupoProdutoDAO.buscarTodos();
	}

	public void excluir() {
		try {
			grupoProdutoDAO.excluir(grupoProdutoSelecionado);
			this.grupoProdutos.remove(grupoProdutoSelecionado);
			facesMessages.info("Grupo Produto "
					+ grupoProdutoSelecionado.getDescricao()
					+ " excluído com sucesso !");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

	}

	public GrupoProduto getGrupoProdutoSelecionado() {
		return grupoProdutoSelecionado;
	}

	public void setGrupoProdutoSelecionado(GrupoProduto grupoProdutoSelecionado) {
		this.grupoProdutoSelecionado = grupoProdutoSelecionado;
	}

}
