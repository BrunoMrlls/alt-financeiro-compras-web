package com.andreitoledo.financeiro.compras.model.cadastros.produto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.andreitoledo.financeiro.compras.model.cadastros.entidade.PessoaJuridica;

@Entity
@NamedQueries({ @NamedQuery(name = "Produto.buscarTodos", query = " select p from Produto p "
		+ " left join fetch p.pessoaJuridica "
		+ " left join fetch p.secaoProduto "
		+ " left join fetch p.unidadeMedida "
		+ " left join fetch p.familiaProduto "
		+ " left join fetch p.grupoProduto "
		+ " left join fetch p.subgrupoProduto " + " left join fetch p.marca")

})
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotBlank
	@JoinColumn(nullable = false)
	private String descricao;
	
	@Column(name = "descricao_reduzida")	
	@NotEmpty
	private String descricaoReduzida;
	@ManyToOne
	@JoinColumn(name = "codigo_fabricante")
	private PessoaJuridica pessoaJuridica;
	@ManyToOne
	@JoinColumn(name = "codigo_unidadeMedida")
	private UnidadeMedida unidadeMedida;
	@ManyToOne
	@JoinColumn(name = "codigo_familiaProduto")
	private FamiliaProduto familiaProduto;
	@ManyToOne
	@JoinColumn(name = "codigo_secaoProduto")
	private SecaoProduto secaoProduto;
	@ManyToOne
	@JoinColumn(name = "codigo_grupoProduto")
	private GrupoProduto grupoProduto;
	@ManyToOne
	@JoinColumn(name = "subgrupo_produto")
	private SubgrupoProduto subgrupoProduto;
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_sazonalidade")
	private TipoSazonalidade tipoSazonalidade;
	@ManyToOne
	@JoinColumn(name = "codigo_marca")
	private Marca marca;
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_situacao_produto")
	private TipoSituacaoProduto tipoSituacaoProduto;
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_status_compra")
	private TipoStatusCompra tipoStatusCompra;
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_preco")
	private TipoPreco tipoPreco;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_inclusao")
	private Date dataInclusao;
	private String ncm;
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_situacao_cadastro")
	private TipoSituacaoCadastro tipoSituacaoCadastro;

	/* detail ean */

	private String ean;
	@Column(name = "quantidade_embalagem", nullable = true)
	private Integer quantidadeEmbalagem;
	@Column(name = "ean_interno")
	private String eanInterno;

	/* detail preco_venda */

	@Column(name = "preco_maximo", precision = 10, scale = 2)
	private BigDecimal precoMaximo;
	@Column(name = "preco_fabrica", precision = 10, scale = 2)
	private BigDecimal precoFabrica;
	@Column(name = "desconto_maximo", precision = 6, scale = 2)
	private BigDecimal descontoMaximo;
	@Column(name = "desconto_padrao", precision = 6, scale = 2)
	private BigDecimal descontoPadrao;
	@NotNull
	@Column(name = "preco_venda", nullable = false, precision = 10, scale = 2)
	private BigDecimal precoVenda;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao == null ? null : descricao.toUpperCase();
	}

	public String getDescricaoReduzida() {
		return descricaoReduzida;
	}

	public void setDescricaoReduzida(String descricaoReduzida) {
		this.descricaoReduzida = descricaoReduzida == null ? null
				: descricaoReduzida.toUpperCase();
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public FamiliaProduto getFamiliaProduto() {
		return familiaProduto;
	}

	public void setFamiliaProduto(FamiliaProduto familiaProduto) {
		this.familiaProduto = familiaProduto;
	}

	public SecaoProduto getSecaoProduto() {
		return secaoProduto;
	}

	public void setSecaoProduto(SecaoProduto secaoProduto) {
		this.secaoProduto = secaoProduto;
	}

	public GrupoProduto getGrupoProduto() {
		return grupoProduto;
	}

	public void setGrupoProduto(GrupoProduto grupoProduto) {
		this.grupoProduto = grupoProduto;
	}

	public SubgrupoProduto getSubgrupoProduto() {
		return subgrupoProduto;
	}

	public void setSubgrupoProduto(SubgrupoProduto subgrupoProduto) {
		this.subgrupoProduto = subgrupoProduto;
	}

	public TipoSazonalidade getTipoSazonalidade() {
		return tipoSazonalidade;
	}

	public void setTipoSazonalidade(TipoSazonalidade tipoSazonalidade) {
		this.tipoSazonalidade = tipoSazonalidade;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public TipoSituacaoProduto getTipoSituacaoProduto() {
		return tipoSituacaoProduto;
	}

	public void setTipoSituacaoProduto(TipoSituacaoProduto tipoSituacaoProduto) {
		this.tipoSituacaoProduto = tipoSituacaoProduto;
	}

	public TipoStatusCompra getTipoStatusCompra() {
		return tipoStatusCompra;
	}

	public void setTipoStatusCompra(TipoStatusCompra tipoStatusCompra) {
		this.tipoStatusCompra = tipoStatusCompra;
	}

	public TipoPreco getTipoPreco() {
		return tipoPreco;
	}

	public void setTipoPreco(TipoPreco tipoPreco) {
		this.tipoPreco = tipoPreco;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public TipoSituacaoCadastro getTipoSituacaoCadastro() {
		return tipoSituacaoCadastro;
	}

	public void setTipoSituacaoCadastro(
			TipoSituacaoCadastro tipoSituacaoCadastro) {
		this.tipoSituacaoCadastro = tipoSituacaoCadastro;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public Integer getQuantidadeEmbalagem() {
		return quantidadeEmbalagem;
	}

	public void setQuantidadeEmbalagem(Integer quantidadeEmbalagem) {
		this.quantidadeEmbalagem = quantidadeEmbalagem;
	}

	public String getEanInterno() {
		return eanInterno;
	}

	public void setEanInterno(String eanInterno) {
		this.eanInterno = eanInterno;
	}

	public BigDecimal getPrecoMaximo() {
		return precoMaximo;
	}

	public void setPrecoMaximo(BigDecimal precoMaximo) {
		this.precoMaximo = precoMaximo;
	}

	public BigDecimal getPrecoFabrica() {
		return precoFabrica;
	}

	public void setPrecoFabrica(BigDecimal precoFabrica) {
		this.precoFabrica = precoFabrica;
	}

	public BigDecimal getDescontoMaximo() {
		return descontoMaximo;
	}

	public void setDescontoMaximo(BigDecimal descontoMaximo) {
		this.descontoMaximo = descontoMaximo;
	}

	public BigDecimal getDescontoPadrao() {
		return descontoPadrao;
	}

	public void setDescontoPadrao(BigDecimal descontoPadrao) {
		this.descontoPadrao = descontoPadrao;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
