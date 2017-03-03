package com.andreitoledo.financeiro.compras.controller.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.PessoaJuridicaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.EmpresaUsuaria;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.PessoaJuridica;
import com.andreitoledo.financeiro.compras.service.CadastroEmpresaUsuariaService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroEmpresaUsuariaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private EmpresaUsuaria empresaUsuaria;
	
	@Inject
	private CadastroEmpresaUsuariaService cadastroEmpresaUsuariaService;	
	
	private List<PessoaJuridica> pessoasJuridicas;
	
	@Inject
	private PessoaJuridicaDAO pessoaJuridicaDAO;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (this.empresaUsuaria == null) {
			limpar();
		}
		
		this.pessoasJuridicas = pessoaJuridicaDAO.buscarTodos();
	}

	public void limpar() {
		this.empresaUsuaria = new EmpresaUsuaria();
	}

	public void salvar() {
		try {
			this.cadastroEmpresaUsuariaService.salvar(empresaUsuaria);
			facesMessages.info("Empresa usuaria salva com sucesso !");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}

	}

	public EmpresaUsuaria getEmpresaUsuaria() {
		return empresaUsuaria;
	}

	public void setEmpresaUsuaria(EmpresaUsuaria empresaUsuaria) {
		this.empresaUsuaria = empresaUsuaria;
	}

	public List<PessoaJuridica> getPessoasJuridicas() {
		return pessoasJuridicas;
	}

	public boolean isEditando() {
		return this.empresaUsuaria.getCodigo() != null;
	}

}
