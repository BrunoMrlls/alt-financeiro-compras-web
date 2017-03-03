package com.andreitoledo.financeiro.compras.controller.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.EmpresaUsuariaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.EmpresaUsuaria;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaEmpresaUsuariaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EmpresaUsuariaDAO empresaUsuariaDAO;

	private List<EmpresaUsuaria> empresasUsuarias = new ArrayList<>();

	private EmpresaUsuaria empresaUsuariaSelecionado;

	@Inject
	private FacesMessages facesMessages;

	public List<EmpresaUsuaria> getEmpresasUsuarias() {
		return empresasUsuarias;
	}

	@PostConstruct
	public void inicializar() {
		empresasUsuarias = empresaUsuariaDAO.buscarTodos();

	}

	public void excluir() {
		try {
			empresaUsuariaDAO.excluir(empresaUsuariaSelecionado);
			this.empresasUsuarias.remove(empresaUsuariaSelecionado);
			facesMessages.info("Empresa Usuaria "
					+ empresaUsuariaSelecionado.getNome()
					+ " excluído com sucesso !");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public EmpresaUsuaria getEmpresaUsuariaSelecionado() {
		return empresaUsuariaSelecionado;
	}

	public void setEmpresaUsuariaSelecionado(
			EmpresaUsuaria empresaUsuariaSelecionado) {
		this.empresaUsuariaSelecionado = empresaUsuariaSelecionado;
	}

}
