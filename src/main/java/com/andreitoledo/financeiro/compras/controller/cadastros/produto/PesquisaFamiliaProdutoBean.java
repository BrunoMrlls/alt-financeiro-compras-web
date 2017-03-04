package com.andreitoledo.financeiro.compras.controller.cadastros.produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.FamiliaProdutoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.FamiliaProduto;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaFamiliaProdutoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<FamiliaProduto> familiaProdutos = new ArrayList<>();
	
	private FamiliaProduto familiaProdutoSelecionado;
	
	@Inject
	FamiliaProdutoDAO familiaProdutoDAO;

	@Inject
	private FacesMessages facesMessages;
	
	public List<FamiliaProduto> getFamiliaProdutos() {
		return familiaProdutos;
	}
	
	@PostConstruct
	public void inicializar(){
		this.familiaProdutos = familiaProdutoDAO.buscarTodos();		
	}
	
	public void excluir(){
		try {
			familiaProdutoDAO.excluir(familiaProdutoSelecionado);
			this.familiaProdutos.remove(familiaProdutoSelecionado);
			facesMessages.info("Familia Produto "
					 + familiaProdutoSelecionado.getDescricao()
					 + " excluído com sucesso !");
			
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}	
		
	}

	public FamiliaProduto getFamiliaProdutoSelecionado() {
		return familiaProdutoSelecionado;
	}

	public void setFamiliaProdutoSelecionado(
			FamiliaProduto familiaProdutoSelecionado) {
		this.familiaProdutoSelecionado = familiaProdutoSelecionado;
	}
	

}
