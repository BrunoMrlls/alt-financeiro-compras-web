package com.andreitoledo.financeiro.compras.controller.cadastros.entidade;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.ClassifEntidadeDAO;
import com.andreitoledo.financeiro.compras.dao.UnidadeMedidaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.ClassifEntidade;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.PessoaJuridica;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.TipoLogradouro;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.TipoTelefone;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.UnidadeMedida;
import com.andreitoledo.financeiro.compras.service.CadastroPessoaJuridicaService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroPessoaJuridicaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroPessoaJuridicaService cadastroPessoaJuridicaService;

	private PessoaJuridica pessoaJuridica;

	private List<ClassifEntidade> classifEntidades;

	private List<UnidadeMedida> unidadeMedidas;

	@Inject
	private ClassifEntidadeDAO classifEntidadeDAO;

	@Inject
	private UnidadeMedidaDAO unidadeMedidaDAO;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (pessoaJuridica == null) {
			limpar();
		}

		this.classifEntidades = this.classifEntidadeDAO.buscarTodos();
		this.unidadeMedidas = this.unidadeMedidaDAO.buscarTodos();

	}

	public void limpar() {
		this.pessoaJuridica = new PessoaJuridica();
	}

	public void salvar() {
		try {
			this.cadastroPessoaJuridicaService.salvar(pessoaJuridica);
			facesMessages.info("Pessoa Juridica salvo com sucesso !");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

		limpar();
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public List<ClassifEntidade> getClassifEntidades() {
		return classifEntidades;
	}

	public List<UnidadeMedida> getUnidadeMedidas() {
		return unidadeMedidas;
	}

	public TipoLogradouro[] getTipoLogradouros() {
		return TipoLogradouro.values();
	}

	public TipoTelefone[] getTipoTelefones() {
		return TipoTelefone.values();
	}

	public boolean isEditando() {
		return this.pessoaJuridica.getCodigo() != null;
	}

}
