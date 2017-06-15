package com.andreitoledo.financeiro.compras.controller.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.BancoDAO;
import com.andreitoledo.financeiro.compras.dao.EmpresaUsuariaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.Banco;
import com.andreitoledo.financeiro.compras.model.cadastros.ContaBancaria;
import com.andreitoledo.financeiro.compras.model.cadastros.EmpresaUsuaria;
import com.andreitoledo.financeiro.compras.service.CadastroContaBancariaService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroContaBancariaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroContaBancariaService cadastroContaBancariaService;

	private ContaBancaria contaBancaria;

	private List<Banco> bancos;

	private List<EmpresaUsuaria> empresasUsuarias;

	private List<EmpresaUsuaria> sacadorAvalistas;

	@Inject
	private BancoDAO bancoDAO;

	@Inject
	private EmpresaUsuariaDAO empresaUsuariaDAO;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (this.contaBancaria == null) {
			limpar();
		}

		this.bancos = this.bancoDAO.buscarTodos();
		this.empresasUsuarias = this.empresaUsuariaDAO.buscarTodos();
		this.sacadorAvalistas = this.empresaUsuariaDAO.buscarTodos();
	}

	private void limpar() {
		this.contaBancaria = new ContaBancaria();
	}

	public void salvar() {
		try {
			this.cadastroContaBancariaService.salvar(contaBancaria);
			facesMessages.info("Conta bancária salvo com sucesso.");
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			facesMessages.error("Erro desconhecido. Contatar o administrador.");

		}

		limpar();
	}

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public List<Banco> getBancos() {
		return bancos;
	}

	public List<EmpresaUsuaria> getEmpresasUsuarias() {
		return empresasUsuarias;
	}

	public List<EmpresaUsuaria> getSacadorAvalistas() {
		return sacadorAvalistas;
	}

	public boolean isEditando() {
		return this.contaBancaria.getCodigo() != null;
	}

}
