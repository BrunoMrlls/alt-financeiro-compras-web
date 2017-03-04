package com.andreitoledo.financeiro.compras.controller.cadastros.produto;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

import com.andreitoledo.financeiro.compras.dao.FamiliaProdutoDAO;
import com.andreitoledo.financeiro.compras.dao.GrupoProdutoDAO;
import com.andreitoledo.financeiro.compras.dao.MarcaDAO;
import com.andreitoledo.financeiro.compras.dao.PessoaJuridicaDAO;
import com.andreitoledo.financeiro.compras.dao.SecaoProdutoDAO;
import com.andreitoledo.financeiro.compras.dao.SubgrupoProdutoDAO;
import com.andreitoledo.financeiro.compras.dao.UnidadeMedidaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.PessoaJuridica;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.FamiliaProduto;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.GrupoProduto;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.Marca;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.Produto;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.SecaoProduto;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.SubgrupoProduto;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.TipoPreco;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.TipoSazonalidade;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.TipoSituacaoCadastro;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.TipoSituacaoProduto;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.TipoStatusCompra;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.UnidadeMedida;
import com.andreitoledo.financeiro.compras.service.CadastroProdutoService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroProdutoService cadastroProdutoService;

	private Produto produto;

	private List<PessoaJuridica> pessoasJuridicas;

	private List<UnidadeMedida> unidadeMedidas;

	private List<SecaoProduto> secaoProdutos;
	
	private List<FamiliaProduto> familiaProdutos;
	
	private List<GrupoProduto> grupoProdutos;
	
	private List<SubgrupoProduto> subgrupoProdutos;
	
	private List<Marca> marcas;

	@Inject
	private PessoaJuridicaDAO PessoaJuridicaDAO;

	@Inject
	private UnidadeMedidaDAO unidadeMedidaDAO;

	@Inject
	private SecaoProdutoDAO secaoProdutoDAO;
	
	@Inject
	private FamiliaProdutoDAO familiaProdutoDAO;
	
	@Inject
	private GrupoProdutoDAO grupoProdutoDAO;
	
	@Inject
	private SubgrupoProdutoDAO subgrupoProdutoDAO;
	
	@Inject
	private MarcaDAO marcaDAO;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (produto == null) {
			limpar();
		}

		this.pessoasJuridicas = this.PessoaJuridicaDAO.buscarTodos();
		this.unidadeMedidas = this.unidadeMedidaDAO.buscarTodos();
		this.secaoProdutos = this.secaoProdutoDAO.buscarTodos();
		this.familiaProdutos = this.familiaProdutoDAO.buscarTodos();
		this.grupoProdutos = this.grupoProdutoDAO.buscarTodos();
		this.subgrupoProdutos = this.subgrupoProdutoDAO.buscarTodos();
		this.marcas = this.marcaDAO.buscarTodos();
	}

	public void limpar() {
		this.produto = new Produto();
	}
	
	public void pessoaJuridicaSelecionado(SelectEvent event){
		PessoaJuridica pessoaJuridica = (PessoaJuridica) event.getObject();
		produto.setPessoaJuridica(pessoaJuridica);
	}

	public void salvar() {
		try {
			this.cadastroProdutoService.salvar(produto);
			facesMessages.info("Produto salvo com sucesso !");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<PessoaJuridica> getPessoasJuridicas() {
		return pessoasJuridicas;
	}

	public List<UnidadeMedida> getUnidadeMedidas() {
		return unidadeMedidas;
	}

	public List<SecaoProduto> getSecaoProdutos() {
		return secaoProdutos;
	}

	public List<FamiliaProduto> getFamiliaProdutos() {
		return familiaProdutos;
	}

	public List<GrupoProduto> getGrupoProdutos() {
		return grupoProdutos;
	}	

	public List<SubgrupoProduto> getSubgrupoProdutos() {
		return subgrupoProdutos;
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public TipoSituacaoProduto[] getTipoSituacaoProdutos() {
		return TipoSituacaoProduto.values();
	}

	public TipoStatusCompra[] getTipoStatusCompras() {
		return TipoStatusCompra.values();
	}

	public TipoPreco[] getTipoPrecos() {
		return TipoPreco.values();
	}
	
	public TipoSazonalidade[] getTipoSazonalidades(){
		return TipoSazonalidade.values();
	}
	
	public TipoSituacaoCadastro[] getTipoSituacaoCadastros(){
		return TipoSituacaoCadastro.values();
	}

	public boolean isEditando() {
		return this.produto.getCodigo() != null;
	}	
	
	@NotBlank
	public String getNomePessoaJuridica(){
		return produto.getPessoaJuridica() == null
				? null : produto.getPessoaJuridica().getNome();
	}
	
	public void setNomePessoaJuridica(String nome){
		
	}

}
