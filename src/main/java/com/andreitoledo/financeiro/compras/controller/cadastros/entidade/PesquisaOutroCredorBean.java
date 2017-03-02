package com.andreitoledo.financeiro.compras.controller.cadastros.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.OutroCredorDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.OutroCredor;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaOutroCredorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	OutroCredorDAO outroCredorDAO;

	private List<OutroCredor> outrosCredores = new ArrayList<>();

	private OutroCredor outroCredorSelecionado;
	
	@Inject
	private FacesMessages facesMessages;

	public List<OutroCredor> getOutrosCredores() {
		return outrosCredores;
	}

	@PostConstruct
	public void inicializar() {
		outrosCredores = outroCredorDAO.buscarTodos();
	}

	public void excluir() {
		try {
			outroCredorDAO.excluir(outroCredorSelecionado);
			this.outrosCredores.remove(outroCredorSelecionado);
			facesMessages.info("Outro Credor "
					+ outroCredorSelecionado.getNome()
					+ " excluído com sucesso !");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public OutroCredor getOutroCredorSelecionado() {
		return outroCredorSelecionado;
	}

	public void setOutroCredorSelecionado(OutroCredor outroCredorSelecionado) {
		this.outroCredorSelecionado = outroCredorSelecionado;
	}

}
