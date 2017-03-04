package com.andreitoledo.financeiro.compras.controller.cadastros.produto;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.model.cadastros.produto.UnidadeMedida;
import com.andreitoledo.financeiro.compras.service.CadastroUnidadeMedidaService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroUnidadeMedidaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroUnidadeMedidaService cadastroUnidadeMedidaService;

	private UnidadeMedida unidadeMedida;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (unidadeMedida == null) {
			limpar();
		}
	}

	private void limpar() {
		this.unidadeMedida = new UnidadeMedida();
	}

	public void salvar() {
		try {
			this.cadastroUnidadeMedidaService.salvar(unidadeMedida);
			facesMessages.info("Unidade de Medida salvo com sucesso !");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public boolean isEditando() {
		return this.unidadeMedida.getCodigo() != null;
	}

}
