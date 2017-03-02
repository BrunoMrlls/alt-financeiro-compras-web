package com.andreitoledo.financeiro.compras.controller.cadastros;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.model.cadastros.Departamento;
import com.andreitoledo.financeiro.compras.service.CadastroDepartamentoService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroDepartamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroDepartamentoService cadastroDepartamentoService;

	private Departamento departamento;
	
	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (this.departamento == null) {
			limpar();
		}
	}	

	public void salvar() {
		try {
			this.cadastroDepartamentoService.salvar(departamento);
			facesMessages.info("Departamento salvo com sucesso !");
			

			limpar();

		} catch (NegocioException e) {			
			facesMessages.error(e.getMessage());

		}
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public boolean isEditando() {
		return this.departamento.getCodigo() != null;
	}
	
	private void limpar() {
		this.departamento = new Departamento();
	}

}
