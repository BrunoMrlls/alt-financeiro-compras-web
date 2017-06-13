package com.andreitoledo.financeiro.compras.controller.cadastros;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.model.cadastros.Banco;
import com.andreitoledo.financeiro.compras.service.CadastroBancoService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroBancoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroBancoService cadastroBancoService;

	private Banco banco;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (this.banco == null) {
			limpar();
		}
	}

	public void salvar() {
		try {
			this.cadastroBancoService.salvar(banco);
			facesMessages.info("Banco salvo com sucesso.");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public boolean isEditando() {
		return this.banco.getCodigo() != null;
	}

	private void limpar() {
		this.banco = new Banco();

	}

}
