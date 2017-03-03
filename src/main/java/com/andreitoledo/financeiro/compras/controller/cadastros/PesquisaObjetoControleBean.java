package com.andreitoledo.financeiro.compras.controller.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.ObjetoControleDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.ObjetoControle;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaObjetoControleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	ObjetoControleDAO objetoControleDAO;

	private List<ObjetoControle> objetosControles = new ArrayList<>();

	private ObjetoControle objetoControleSelecionado;

	@Inject
	private FacesMessages facesMessages;

	public List<ObjetoControle> getObjetosControles() {
		return objetosControles;
	}

	@PostConstruct
	public void inicializar() {
		objetosControles = objetoControleDAO.buscarTodos();
	}

	public void excluir() {
		try {
			objetoControleDAO.excluir(objetoControleSelecionado);
			this.objetosControles.remove(objetoControleSelecionado);
			facesMessages.info("Objeto Controle "
					+ objetoControleSelecionado.getDescricao()
					+ " excluído com sucesso !");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

	}

	public ObjetoControle getObjetoControleSelecionado() {
		return objetoControleSelecionado;
	}

	public void setObjetoControleSelecionado(
			ObjetoControle objetoControleSelecionado) {
		this.objetoControleSelecionado = objetoControleSelecionado;
	}

}
