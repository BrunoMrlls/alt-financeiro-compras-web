package com.andreitoledo.financeiro.compras.controller.cadastros.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.FuncionarioDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.Funcionario;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaFuncionarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	FuncionarioDAO funcionarioDAO;
	
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	private Funcionario funcionarioSelecionado;
	
	@Inject
	private FacesMessages facesMessages;	
	
	public List<Funcionario> getFuncionarios(){
		return funcionarios;
	}
	
	@PostConstruct
	public void inicializar(){
		funcionarios = funcionarioDAO.buscarTodos();
	}
	
	public void excluir(){
		try {
			funcionarioDAO.excluir(funcionarioSelecionado);
			this.funcionarios.remove(funcionarioSelecionado);
			facesMessages.info("Funcionario "
					+ funcionarioSelecionado.getNome()
					+ " excluído com sucesso !");
			
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

}
