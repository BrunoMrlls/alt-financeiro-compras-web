package com.andreitoledo.financeiro.compras.controller.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.ContaBancariaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.ContaBancaria;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaContaBancariaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	ContaBancariaDAO contaBancariaDAO;

	private List<ContaBancaria> contasBancarias = new ArrayList<>();

	private ContaBancaria contaBancariaSelecionado;

	@Inject
	private FacesMessages facesMessages;

	public List<ContaBancaria> getContasBancarias() {
		return contasBancarias;
	}

	@PostConstruct
	public void inicializar() {
		contasBancarias = contaBancariaDAO.buscarTodos();
	}

	public void excluir() {
		try {
			contaBancariaDAO.excluir(contaBancariaSelecionado);
			this.contasBancarias.remove(contaBancariaSelecionado);
			facesMessages.info("Conta bancária "
					+ contaBancariaSelecionado.getDescricao()
					+ " excluído com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public ContaBancaria getContaBancariaSelecionado() {
		return contaBancariaSelecionado;
	}

	public void setContaBancariaSelecionado(
			ContaBancaria contaBancariaSelecionado) {
		this.contaBancariaSelecionado = contaBancariaSelecionado;
	}

}
