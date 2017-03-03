package com.andreitoledo.financeiro.compras.controller.cadastros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.UsuarioDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.Usuario;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaUsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	UsuarioDAO usuarioDAO;
	
	private List<Usuario> usuarios = new ArrayList<>();
	
	private Usuario usuarioSelecionado;
	
	@Inject
	private FacesMessages facesMessages;
	
	public List<Usuario> getUsuarios(){
		return usuarios;
	}
	
	@PostConstruct
	public void inicializar(){
		usuarios = usuarioDAO.buscarTodos();
	}
	
	public void excluir(){
		try {
			usuarioDAO.excluir(usuarioSelecionado);
			this.usuarios.remove(usuarioSelecionado);
			facesMessages.info("Usuario " 
			+ usuarioSelecionado.getNome()
			+ " excluído com sucesso !");
			
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}	

}
