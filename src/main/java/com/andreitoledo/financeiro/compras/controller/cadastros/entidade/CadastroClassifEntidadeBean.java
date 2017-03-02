package com.andreitoledo.financeiro.compras.controller.cadastros.entidade;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.model.cadastros.entidade.ClassifEntidade;
import com.andreitoledo.financeiro.compras.service.CadastroClassifEntidadeService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroClassifEntidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ClassifEntidade classifEntidade;

	@Inject
	private CadastroClassifEntidadeService cadastroClassifEntidadeService;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (classifEntidade == null) {
			limpar();
		}
	}

	public void limpar() {
		this.classifEntidade = new ClassifEntidade();
	}

	public void salvar() {
		try {
			this.cadastroClassifEntidadeService.salvar(classifEntidade);
			facesMessages.info("Classificação salva com sucesso !");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}

	}

	public ClassifEntidade getClassifEntidade() {
		return classifEntidade;
	}

	public void setClassifEntidade(ClassifEntidade classifEntidade) {
		this.classifEntidade = classifEntidade;
	}

	public boolean isEditando() {
		return this.classifEntidade.getCodigo() != null;
	}

}
