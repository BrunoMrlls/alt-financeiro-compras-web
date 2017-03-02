package com.andreitoledo.financeiro.compras.controller.cadastros.entidade;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.model.cadastros.entidade.OutroCredor;
import com.andreitoledo.financeiro.compras.service.CadastroOutroCredorService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroOutroCredorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private OutroCredor outroCredor;

	@Inject
	private CadastroOutroCredorService cadastroOutroCredorService;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (outroCredor == null) {
			limpar();
		}
	}

	public void limpar() {
		this.outroCredor = new OutroCredor();
	}

	public void salvar() {
		try {
			this.cadastroOutroCredorService.salvar(outroCredor);
			facesMessages.info("Outro Credor salvo com sucesso !");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

		limpar();
	}

	public OutroCredor getOutroCredor() {
		return outroCredor;
	}

	public void setOutroCredor(OutroCredor outroCredor) {
		this.outroCredor = outroCredor;
	}

	public boolean isEditando() {
		return this.outroCredor.getCodigo() != null;
	}

}
