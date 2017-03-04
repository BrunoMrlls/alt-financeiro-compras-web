package com.andreitoledo.financeiro.compras.controller.cadastros.produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.MarcaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.Marca;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaMarcaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Marca> marcas = new ArrayList<>();

	private Marca marcaSelecionado;

	@Inject
	MarcaDAO marcaDAO;

	@Inject
	private FacesMessages facesmessages;

	public List<Marca> getMarcas() {
		return marcas;
	}

	@PostConstruct
	public void inicializar() {
		marcas = marcaDAO.buscarTodos();
	}

	public void excluir() {
		try {
			marcaDAO.excluir(marcaSelecionado);
			marcas.remove(marcaSelecionado);
			facesmessages.info("Marca " + marcaSelecionado.getDescricao()
					+ " excluído com sucesso !");

		} catch (NegocioException e) {
			facesmessages.error(e.getMessage());

		}
	}

	public Marca getMarcaSelecionado() {
		return marcaSelecionado;
	}

	public void setMarcaSelecionado(Marca marcaSelecionado) {
		this.marcaSelecionado = marcaSelecionado;
	}

}
