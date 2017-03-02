package com.andreitoledo.financeiro.compras.controller.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.DepartamentoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.Departamento;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaDepartamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	DepartamentoDAO departamentoDAO;

	private List<Departamento> departamentos = new ArrayList<>();

	private Departamento departamentoSelecionado;
	
	@Inject
	private FacesMessages facesMessages;

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	@PostConstruct
	public void inicializar() {
		departamentos = departamentoDAO.buscarTodos();
	}

	public void excluir() {
		try {
			departamentoDAO.excluir(departamentoSelecionado);
			this.departamentos.remove(departamentoSelecionado);
			facesMessages.info("Departamento "
					+ departamentoSelecionado.getNome()
					+ " excluído com sucesso !");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}
	}

	public Departamento getDepartamentoSelecionado() {
		return departamentoSelecionado;
	}

	public void setDepartamentoSelecionado(Departamento departamentoSelecionado) {
		this.departamentoSelecionado = departamentoSelecionado;
	}

}
