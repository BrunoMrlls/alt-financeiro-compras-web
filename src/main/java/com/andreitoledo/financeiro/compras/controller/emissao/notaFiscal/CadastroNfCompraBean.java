package com.andreitoledo.financeiro.compras.controller.emissao.notaFiscal;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.EmpresaUsuariaDAO;
import com.andreitoledo.financeiro.compras.dao.PessoaJuridicaDAO;
import com.andreitoledo.financeiro.compras.dao.ProdutoDAO;
import com.andreitoledo.financeiro.compras.dao.UsuarioDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.EmpresaUsuaria;
import com.andreitoledo.financeiro.compras.model.cadastros.Usuario;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.PessoaJuridica;
import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.NfCompra;
import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.NfCompraItemProduto;
import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.StatusPedido;
import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.TipoLogradouro;
import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.TipoNfEspecie;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.Produto;
import com.andreitoledo.financeiro.compras.service.CadastroNfCompraService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroNfCompraBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Usuario> usuarios;

	private List<PessoaJuridica> entidades;

	private List<EmpresaUsuaria> empresas;

	private List<PessoaJuridica> entidadesEntregas;

	private List<PessoaJuridica> entidadesTransportes;

	private List<PessoaJuridica> entidadesFornecedores;

	@Inject
	private CadastroNfCompraService cadastroNfCompraService;

	@Inject
	private UsuarioDAO usuarioDAO;

	@Inject
	private PessoaJuridicaDAO pessoaJuridicaDAO;

	@Inject
	private EmpresaUsuariaDAO empresaUsuariaDAO;

	@Inject
	private ProdutoDAO produtoDAO;

	@Inject
	private FacesMessages facesMessage;

	@Produces
	@PedidoEdicao
	private NfCompra nfCompra;

	private Produto produtoLinhaEditavel;

	public CadastroNfCompraBean() {
		limpar();
	}

	public void inicializar() {
		if (this.nfCompra == null) {
			limpar();

		}

		this.usuarios = this.usuarioDAO.buscarTodos();
		this.entidades = this.pessoaJuridicaDAO.buscarTodos();
		this.entidadesEntregas = this.pessoaJuridicaDAO.buscarTodos();
		this.empresas = this.empresaUsuariaDAO.buscarTodos();
		this.entidadesTransportes = this.pessoaJuridicaDAO.buscarTodos();
		this.entidadesFornecedores = this.pessoaJuridicaDAO.buscarTodos();

		this.nfCompra.adicionarItemVazio();

	}

	private void limpar() {
		nfCompra = new NfCompra();

	}

	public void pedidoAlterado(@Observes PedidoAlteradoNfCompraEvent event) {
		this.nfCompra = event.getNfCompra();

	}

	public void salvar() {
		this.nfCompra.removerItemVazio();

		try {
			this.nfCompra = this.cadastroNfCompraService.salvar(this.nfCompra);

			facesMessage.info("Nota de Compra salvo com sucesso.");

			limpar();

		} catch (NegocioException e) {
			facesMessage.error(e.getMessage());

		} finally {
			this.nfCompra.adicionarItemVazio();
		}
	}

	public void carregarProdutoLinhaEditavel() {
		NfCompraItemProduto item = this.nfCompra.getNfCompraItensProduto().get(
				0);

		if (this.produtoLinhaEditavel != null) {
			if (this.existeItemComProduto(this.produtoLinhaEditavel)) {
				facesMessage
						.error("Já existe um item no pedido com o produto informado.");
			} else {
				item.setProduto(this.produtoLinhaEditavel);
				item.setValorUnitario(this.produtoLinhaEditavel.getPrecoVenda());

				this.nfCompra.adicionarItemVazio();
				this.produtoLinhaEditavel = null;

			}

		}
	}

	private boolean existeItemComProduto(Produto produto) {
		boolean existeItem = false;

		for (NfCompraItemProduto item : this.getNfCompra()
				.getNfCompraItensProduto()) {
			if (produto.equals(item.getProduto())) {
				existeItem = true;
				break;

			}

		}

		return existeItem;

	}

	public List<Produto> completarProduto(String descricao) {
		return this.produtoDAO.porDescricao(descricao);
	}

	public NfCompra getNfCompra() {
		return nfCompra;
	}

	public void setNfCompra(NfCompra nfCompra) {
		this.nfCompra = nfCompra;
	}

	public Produto getProdutoLinhaEditavel() {
		return produtoLinhaEditavel;
	}

	public void setProdutoLinhaEditavel(Produto produtoLinhaEditavel) {
		this.produtoLinhaEditavel = produtoLinhaEditavel;
	}

	public TipoNfEspecie[] getTipoNfEspecies() {
		return TipoNfEspecie.values();
	}

	public StatusPedido[] getStatusPedidos() {
		return StatusPedido.values();
	}

	public TipoLogradouro[] getTipoLogradouros() {
		return TipoLogradouro.values();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<PessoaJuridica> getEntidades() {
		return entidades;
	}

	public List<PessoaJuridica> getEntidadesEntregas() {
		return entidadesEntregas;
	}

	public List<EmpresaUsuaria> getEmpresas() {
		return empresas;
	}

	public List<PessoaJuridica> getEntidadesTransportes() {
		return entidadesTransportes;
	}

	public List<PessoaJuridica> getEntidadesFornecedores() {
		return entidadesFornecedores;
	}

	public boolean isEditando() {
		return this.nfCompra.getCodigo() != null;
	}

}
