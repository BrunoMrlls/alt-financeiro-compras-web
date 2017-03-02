package com.andreitoledo.financeiro.compras.controller.cadastros.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.PessoaJuridicaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.PessoaJuridica;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaPessoaJuridicaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	PessoaJuridicaDAO pessoaJuridicaDAO;

	private List<PessoaJuridica> pessoasJuridicas = new ArrayList<>();

	private PessoaJuridica pessoaJuridicaSelecionado;
	
	@Inject
	private FacesMessages facesMessages;

	public List<PessoaJuridica> getPessoasJuridicas() {
		return pessoasJuridicas;
	}

	@PostConstruct
	public void inicializar() {
		pessoasJuridicas = pessoaJuridicaDAO.buscarTodos();
	}

	public void excluir() {
		try {
			pessoaJuridicaDAO.excluir(pessoaJuridicaSelecionado);
			this.pessoasJuridicas.remove(pessoaJuridicaSelecionado);
			facesMessages.info("Pessoa Juridica "
					+ pessoaJuridicaSelecionado.getNome()
					+ " excluído com sucesso !");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public PessoaJuridica getPessoaJuridicaSelecionado() {
		return pessoaJuridicaSelecionado;
	}

	public void setPessoaJuridicaSelecionado(
			PessoaJuridica pessoaJuridicaSelecionado) {
		this.pessoaJuridicaSelecionado = pessoaJuridicaSelecionado;
	}
}
