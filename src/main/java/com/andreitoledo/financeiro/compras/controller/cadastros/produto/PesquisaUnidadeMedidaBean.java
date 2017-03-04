package com.andreitoledo.financeiro.compras.controller.cadastros.produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.UnidadeMedidaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.UnidadeMedida;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaUnidadeMedidaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	UnidadeMedidaDAO unidadeMedidaDAO;

	private List<UnidadeMedida> unidademedidas = new ArrayList<>();

	private UnidadeMedida unidadeMedidaSelecionado;
	
	@Inject
	private FacesMessages facesMessages;

	public List<UnidadeMedida> getUnidadeMedidas() {
		return unidademedidas;
	}

	@PostConstruct
	public void inicializar(){
		this.unidademedidas = unidadeMedidaDAO.buscarTodos();
	}
	
	public void excluir() {
		try {
			unidadeMedidaDAO.excluir(unidadeMedidaSelecionado);
			this.unidademedidas.remove(unidadeMedidaSelecionado);
			facesMessages.info("Unidade Medida "
					+ unidadeMedidaSelecionado.getDescricao()
					+ " excluído com sucesso !");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}
	}

	public UnidadeMedida getUnidadeMedidaSelecionado() {
		return unidadeMedidaSelecionado;
	}

	public void setUnidadeMedidaSelecionado(
			UnidadeMedida unidadeMedidaSelecionado) {
		this.unidadeMedidaSelecionado = unidadeMedidaSelecionado;
	}

}
