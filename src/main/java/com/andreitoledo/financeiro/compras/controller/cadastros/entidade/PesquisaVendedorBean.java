package com.andreitoledo.financeiro.compras.controller.cadastros.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.VendedorDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.Vendedor;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaVendedorBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	VendedorDAO vendedorDAO;
	
	private List<Vendedor> vendedores = new ArrayList<>();
	
	private Vendedor vendedorSelecionado;
	
	@Inject
	private FacesMessages facesMessages;
	
	
	public List<Vendedor> getVendedores(){
		return vendedores;
	}
	
	@PostConstruct
	public void inicializar(){
		vendedores = vendedorDAO.buscarTodos();
	}
	
	public void excluir(){
		try {
			vendedorDAO.excluir(vendedorSelecionado);
			this.vendedores.remove(vendedorSelecionado);
			facesMessages.info("Vendedor "
					+ vendedorSelecionado.getNome()
					+ " excluído com sucesso !");
			
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());			

		}
	}

	public Vendedor getVendedorSelecionado() {
		return vendedorSelecionado;
	}

	public void setVendedorSelecionado(Vendedor vendedorSelecionado) {
		this.vendedorSelecionado = vendedorSelecionado;
	}

}
