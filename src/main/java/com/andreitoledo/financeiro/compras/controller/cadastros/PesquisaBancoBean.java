package com.andreitoledo.financeiro.compras.controller.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.BancoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.Banco;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaBancoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	BancoDAO bancoDAO;

	private List<Banco> bancos = new ArrayList<>();

	private Banco bancoSelecionado;

	@Inject
	private FacesMessages facesMessages;

	public List<Banco> getBancos() {
		return bancos;
	}

	@PostConstruct
	public void inicializar() {
		bancos = bancoDAO.buscarTodos();
	}

	public void excluir() {
		try {
			bancoDAO.excluir(bancoSelecionado);
			this.bancos.remove(bancoSelecionado);
			facesMessages.info("Banco " 
			+ bancoSelecionado.getNome()
			+ " excluído com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public Banco getBancoSelecionado() {
		return bancoSelecionado;
	}

	public void setBancoSelecionado(Banco bancoSelecionado) {
		this.bancoSelecionado = bancoSelecionado;
	}

}
