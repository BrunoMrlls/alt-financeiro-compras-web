package com.andreitoledo.financeiro.compras.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.andreitoledo.financeiro.compras.dao.PessoaJuridicaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.PessoaJuridica;

@Named
@ViewScoped
public class SelecaoEntidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PessoaJuridicaDAO pessoaJuridicaDAO;
	
	private String nome;
	
	private List<PessoaJuridica> pessoasJuridicasFiltrados;

	public void pesquisar() {
		pessoasJuridicasFiltrados = pessoaJuridicaDAO.porNomeSemelhante(nome);
	}
	
	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 470);
		
		RequestContext.getCurrentInstance().openDialog("SelecaoPessoaJuridica", opcoes, null);
	}
	
	public void selecionar(PessoaJuridica pessoaJuridica) {
		RequestContext.getCurrentInstance().closeDialog(pessoaJuridica);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<PessoaJuridica> getPessoasJuridicasFiltrados() {
		return pessoasJuridicasFiltrados;
	}	

}