package com.andreitoledo.financeiro.compras.controller.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.DepartamentoDAO;
import com.andreitoledo.financeiro.compras.dao.PessoaJuridicaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.Departamento;
import com.andreitoledo.financeiro.compras.model.cadastros.Usuario;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.PessoaJuridica;
import com.andreitoledo.financeiro.compras.service.CadastroUsuarioService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroUsuarioService cadastroUsuarioService;
	
	private Usuario usuario;
	
	private List<Departamento> departamentos;
	
	private List<PessoaJuridica> pessoasJuridicas;
	
	@Inject
	private DepartamentoDAO departamentoDAO;
	
	@Inject
	private PessoaJuridicaDAO pessoaJuridicaDAO;
	
	@Inject
	private FacesMessages facesMessages;	
	
	public void inicializar(){
		if(this.usuario == null){
			limpar();			
		}		
		
		this.departamentos = this.departamentoDAO.buscarTodos();
		this.pessoasJuridicas = this.pessoaJuridicaDAO.buscarTodos();
		
	}

	private void limpar() {
		this.usuario = new Usuario();		
	}
	
	public void salvar(){
		try {
			this.cadastroUsuarioService.salvar(usuario);
			facesMessages.info("Usuario Salvo com sucesso !");						
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		} catch(Exception e){
			e.printStackTrace();
			facesMessages.error("Erro desconhecido. Contatar o administrator.");
			
		}
		
		limpar();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public List<PessoaJuridica> getPessoasJuridicas() {
		return pessoasJuridicas;
	}
	
	public boolean isEditando() {
		return this.usuario.getCodigo() != null;
	}
	
}
