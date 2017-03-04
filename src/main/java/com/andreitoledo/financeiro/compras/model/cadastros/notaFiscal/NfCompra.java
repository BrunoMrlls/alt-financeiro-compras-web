package com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.andreitoledo.financeiro.compras.model.cadastros.EmpresaUsuaria;
import com.andreitoledo.financeiro.compras.model.cadastros.Usuario;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.PessoaJuridica;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.Produto;

@Entity
@NamedQueries({ @NamedQuery(name = "NfCompra.buscarTodos", query = " select nfc from NfCompra nfc "
		+ " left join fetch nfc.usuario "
		+ " left join fetch nfc.empresaUsuaria "
		+ " left join fetch nfc.entidade "
		+ " left join fetch nfc.entidadeEntrega"
		+ " left join fetch nfc.entidadeTransporte"
		+ " left join fetch nfc.entidadeFornecedor") })
@Table(name = "nf_compra")
public class NfCompra implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@ManyToOne
	@JoinColumn(name = "codigo_usuario")
	@NotNull
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "codigo_empresa_usuaria")
	@NotNull
	private EmpresaUsuaria empresaUsuaria;
	@ManyToOne
	@JoinColumn(name = "codigo_entidade")
	@NotNull
	private PessoaJuridica entidade;
	@Enumerated(EnumType.STRING)
	@Column(name = "codigo_nf_especie")
	@NotNull
	private TipoNfEspecie tipoNfEspecie;
	@Column(name = "nf_numero")
	@NotNull
	private Integer nfNumero;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_emissao")
	private Date dataEmissao;
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "data_movimento")
	private Date dataMovimento;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_cancelamento")
	private Date dataCancelamento;
	@NotNull
	@Column(name = "valor_total", nullable = false, precision = 10, scale = 2)
	private BigDecimal valorTotal = BigDecimal.ZERO;
	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusPedido status = StatusPedido.ORCAMENTO;
	@Column(columnDefinition = "text")
	private String observacao;
	/* inicio endereco entrega */
	@ManyToOne
	@JoinColumn(name = "codigo_entidade_entrega")
	private PessoaJuridica entidadeEntrega;
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_logradouro")
	private TipoLogradouro tipoLogradouro;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String uf;
	private String pais;
	/* fim endereco entrega */

	/* inicio endereco transporte */
	@ManyToOne
	@JoinColumn(name = "codigo_entidade_trasporte")
	private PessoaJuridica entidadeTransporte;
	@Column(name = "inscricao_federal_transporte")
	private String inscricaoFederalTransporte;
	@Column(name = "inscricao_estadual_transporte")
	private String inscricaoEstadualTransporte;
	@Column(name = "inscricao_municipal_transporte")
	private String inscricaoMunicipalTransporte;
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_logradouro_trasporte")
	private TipoLogradouro tipoLogradouroTransporte;
	@Column(name = "logradouro_transporte")
	private String logradouroTransporte;
	@Column(name = "numero_transporte")
	private String numeroTransporte;
	@Column(name = "complemento_transporte")
	private String complementoTransporte;
	@Column(name = "bairro_transporte")
	private String bairroTransporte;
	@Column(name = "cep_transporte")
	private String cepTransporte;
	@Column(name = "cidade_transporte")
	private String cidadeTransporte;
	@Column(name = "uf_transporte")
	private String ufTransporte;
	@Column(name = "pais_transporte")
	private String paisTransporte;
	@Column(name = "telefone_transporte")
	private String telefoneTransporte;
	@Column(name = "celular_transporte")
	private String celularTransporte;
	@Column(name = "radio_transporte")
	private String radioTransporte;
	/* fim endereco transporte */

	/* inicio endereco fornecedor */
	@ManyToOne
	@JoinColumn(name = "codigo_entidade_fornecedor")
	private PessoaJuridica entidadeFornecedor;
	@Column(name = "inscricao_federal_fornecedor")
	private String inscricaoFederalFornecedor;
	@Column(name = "inscricao_estadual_fornecedor")
	private String inscricaoEstadualFornecedor;
	@Column(name = "inscricao_municipal_fornecedor")
	private String inscricaoMunicipalFornecedor;
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_logradouro_fornecedor")
	private TipoLogradouro tipoLogradouroFornecedor;
	@Column(name = "logradouro_fornecedor")
	private String logradouroFornecedor;
	@Column(name = "numero_fornecedor")
	private String numeroFornecedor;
	@Column(name = "complemento_fornecedor")
	private String complementoFornecedor;
	@Column(name = "bairro_fornecedor")
	private String bairroFornecedor;
	@Column(name = "cep_fornecedor")
	private String cepFornecedor;
	@Column(name = "cidade_fornecedor")
	private String cidadeFornecedor;
	@Column(name = "uf_fornecedor")
	private String ufFornecedor;
	@Column(name = "pais_fornecedor")
	private String paisFornecedor;
	@Column(name = "telefone_fornecedor")
	private String telefoneFornecedor;
	@Column(name = "celular_fornecedor")
	private String celularFornecedor;
	@Column(name = "radio_fornecedor")
	private String radioFornecedor;
	/* fim endereco fornecedor */

	@OneToMany(mappedBy = "nfCompra", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<NfCompraItemProduto> nfCompraItensProduto = new ArrayList<>();

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public EmpresaUsuaria getEmpresaUsuaria() {
		return empresaUsuaria;
	}

	public void setEmpresaUsuaria(EmpresaUsuaria empresaUsuaria) {
		this.empresaUsuaria = empresaUsuaria;
	}

	public PessoaJuridica getEntidade() {
		return entidade;
	}

	public void setEntidade(PessoaJuridica entidade) {
		this.entidade = entidade;
	}

	public TipoNfEspecie getTipoNfEspecie() {
		return tipoNfEspecie;
	}

	public void setTipoNfEspecie(TipoNfEspecie tipoNfEspecie) {
		this.tipoNfEspecie = tipoNfEspecie;
	}

	public Integer getNfNumero() {
		return nfNumero;
	}

	public void setNfNumero(Integer nfNumero) {
		this.nfNumero = nfNumero;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public Date getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(Date dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<NfCompraItemProduto> getNfCompraItensProduto() {
		return nfCompraItensProduto;
	}

	public void setNfCompraItensProduto(
			List<NfCompraItemProduto> nfCompraItensProduto) {
		this.nfCompraItensProduto = nfCompraItensProduto;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public PessoaJuridica getEntidadeEntrega() {
		return entidadeEntrega;
	}

	public void setEntidadeEntrega(PessoaJuridica entidadeEntrega) {
		this.entidadeEntrega = entidadeEntrega;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro == null ? null : logradouro.toUpperCase();
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento == null ? null : complemento.toUpperCase();
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro == null ? null : bairro.toUpperCase();
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade == null ? null : cidade.toUpperCase();
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf == null ? null : uf.toUpperCase();
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getPais() {
		return pais == null ? null : pais.toUpperCase();
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public PessoaJuridica getEntidadeTransporte() {
		return entidadeTransporte;
	}

	public void setEntidadeTransporte(PessoaJuridica entidadeTransporte) {
		this.entidadeTransporte = entidadeTransporte;
	}

	public String getInscricaoFederalTransporte() {
		return inscricaoFederalTransporte;
	}

	public void setInscricaoFederalTransporte(String inscricaoFederalTransporte) {
		this.inscricaoFederalTransporte = inscricaoFederalTransporte;
	}

	public String getInscricaoEstadualTransporte() {
		return inscricaoEstadualTransporte;
	}

	public void setInscricaoEstadualTransporte(
			String inscricaoEstadualTransporte) {
		this.inscricaoEstadualTransporte = inscricaoEstadualTransporte;
	}

	public String getInscricaoMunicipalTransporte() {
		return inscricaoMunicipalTransporte;
	}

	public void setInscricaoMunicipalTransporte(
			String inscricaoMunicipalTransporte) {
		this.inscricaoMunicipalTransporte = inscricaoMunicipalTransporte;
	}

	public TipoLogradouro getTipoLogradouroTransporte() {
		return tipoLogradouroTransporte;
	}

	public void setTipoLogradouroTransporte(
			TipoLogradouro tipoLogradouroTransporte) {
		this.tipoLogradouroTransporte = tipoLogradouroTransporte;
	}

	public String getLogradouroTransporte() {
		return logradouroTransporte == null ? null : logradouroTransporte
				.toUpperCase();
	}

	public void setLogradouroTransporte(String logradouroTransporte) {
		this.logradouroTransporte = logradouroTransporte;
	}

	public String getNumeroTransporte() {
		return numeroTransporte;
	}

	public void setNumeroTransporte(String numeroTransporte) {
		this.numeroTransporte = numeroTransporte;
	}

	public String getComplementoTransporte() {
		return complementoTransporte == null ? null : complementoTransporte
				.toUpperCase();
	}

	public void setComplementoTransporte(String complementoTransporte) {
		this.complementoTransporte = complementoTransporte;
	}

	public String getBairroTransporte() {
		return bairroTransporte == null ? null : bairroTransporte.toUpperCase();
	}

	public void setBairroTransporte(String bairroTransporte) {
		this.bairroTransporte = bairroTransporte;
	}

	public String getCepTransporte() {
		return cepTransporte;
	}

	public void setCepTransporte(String cepTransporte) {
		this.cepTransporte = cepTransporte;
	}

	public String getCidadeTransporte() {
		return cidadeTransporte == null ? null : cidadeTransporte.toUpperCase();
	}

	public void setCidadeTransporte(String cidadeTransporte) {
		this.cidadeTransporte = cidadeTransporte;
	}

	public String getUfTransporte() {
		return ufTransporte == null ? null : ufTransporte.toUpperCase();
	}

	public void setUfTransporte(String ufTransporte) {
		this.ufTransporte = ufTransporte;
	}

	public String getPaisTransporte() {
		return paisTransporte == null ? null : paisTransporte.toUpperCase();
	}

	public void setPaisTransporte(String paisTransporte) {
		this.paisTransporte = paisTransporte;
	}

	public String getTelefoneTransporte() {
		return telefoneTransporte;
	}

	public void setTelefoneTransporte(String telefoneTransporte) {
		this.telefoneTransporte = telefoneTransporte;
	}

	public String getCelularTransporte() {
		return celularTransporte;
	}

	public void setCelularTransporte(String celularTransporte) {
		this.celularTransporte = celularTransporte;
	}

	public String getRadioTransporte() {
		return radioTransporte;
	}

	public void setRadioTransporte(String radioTransporte) {
		this.radioTransporte = radioTransporte;
	}

	public PessoaJuridica getEntidadeFornecedor() {
		return entidadeFornecedor;
	}

	public void setEntidadeFornecedor(PessoaJuridica entidadeFornecedor) {
		this.entidadeFornecedor = entidadeFornecedor;
	}

	public String getInscricaoFederalFornecedor() {
		return inscricaoFederalFornecedor;
	}

	public void setInscricaoFederalFornecedor(String inscricaoFederalFornecedor) {
		this.inscricaoFederalFornecedor = inscricaoFederalFornecedor;
	}

	public String getInscricaoEstadualFornecedor() {
		return inscricaoEstadualFornecedor;
	}

	public void setInscricaoEstadualFornecedor(
			String inscricaoEstadualFornecedor) {
		this.inscricaoEstadualFornecedor = inscricaoEstadualFornecedor;
	}

	public String getInscricaoMunicipalFornecedor() {
		return inscricaoMunicipalFornecedor;
	}

	public void setInscricaoMunicipalFornecedor(
			String inscricaoMunicipalFornecedor) {
		this.inscricaoMunicipalFornecedor = inscricaoMunicipalFornecedor;
	}

	public TipoLogradouro getTipoLogradouroFornecedor() {
		return tipoLogradouroFornecedor;
	}

	public void setTipoLogradouroFornecedor(
			TipoLogradouro tipoLogradouroFornecedor) {
		this.tipoLogradouroFornecedor = tipoLogradouroFornecedor;
	}

	public String getLogradouroFornecedor() {
		return logradouroFornecedor == null ? null : logradouroFornecedor
				.toUpperCase();
	}

	public void setLogradouroFornecedor(String logradouroFornecedor) {
		this.logradouroFornecedor = logradouroFornecedor;
	}

	public String getNumeroFornecedor() {
		return numeroFornecedor;
	}

	public void setNumeroFornecedor(String numeroFornecedor) {
		this.numeroFornecedor = numeroFornecedor;
	}

	public String getComplementoFornecedor() {
		return complementoFornecedor == null ? null : complementoFornecedor
				.toUpperCase();
	}

	public void setComplementoFornecedor(String complementoFornecedor) {
		this.complementoFornecedor = complementoFornecedor;
	}

	public String getBairroFornecedor() {
		return bairroFornecedor == null ? null : bairroFornecedor.toUpperCase();
	}

	public void setBairroFornecedor(String bairroFornecedor) {
		this.bairroFornecedor = bairroFornecedor;
	}

	public String getCepFornecedor() {
		return cepFornecedor;
	}

	public void setCepFornecedor(String cepFornecedor) {
		this.cepFornecedor = cepFornecedor;
	}

	public String getCidadeFornecedor() {
		return cidadeFornecedor == null ? null : cidadeFornecedor.toUpperCase();
	}

	public void setCidadeFornecedor(String cidadeFornecedor) {
		this.cidadeFornecedor = cidadeFornecedor;
	}

	public String getUfFornecedor() {
		return ufFornecedor == null ? null : ufFornecedor.toUpperCase();
	}

	public void setUfFornecedor(String ufFornecedor) {
		this.ufFornecedor = ufFornecedor;
	}

	public String getPaisFornecedor() {
		return paisFornecedor == null ? null : paisFornecedor.toUpperCase();
	}

	public void setPaisFornecedor(String paisFornecedor) {
		this.paisFornecedor = paisFornecedor;
	}

	public String getTelefoneFornecedor() {
		return telefoneFornecedor;
	}

	public void setTelefoneFornecedor(String telefoneFornecedor) {
		this.telefoneFornecedor = telefoneFornecedor;
	}

	public String getCelularFornecedor() {
		return celularFornecedor;
	}

	public void setCelularFornecedor(String celularFornecedor) {
		this.celularFornecedor = celularFornecedor;
	}

	public String getRadioFornecedor() {
		return radioFornecedor;
	}

	public void setRadioFornecedor(String radioFornecedor) {
		this.radioFornecedor = radioFornecedor;
	}

	@Transient
	public boolean isNovo() {
		return getCodigo() == null;
	}

	@Transient
	public boolean isExistente() {
		return !isNovo();
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
		NfCompra other = (NfCompra) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public void adicionarItemVazio() {
		if (this.isOrcamento()) {
			Produto produto = new Produto();

			NfCompraItemProduto item = new NfCompraItemProduto();
			item.setProduto(produto);
			item.setNfCompra(this);

			this.getNfCompraItensProduto().add(0, item);

		}

	}

	@Transient
	public boolean isOrcamento() {
		return StatusPedido.ORCAMENTO.equals(this.getStatus());
	}

	public void removerItemVazio() {
		NfCompraItemProduto primeiroItem = this.getNfCompraItensProduto()
				.get(0);

		if (primeiroItem != null
				&& primeiroItem.getProduto().getCodigo() == null) {
			this.getNfCompraItensProduto().remove(0);

		}
	}

	@Transient
	public boolean isValorTotalNegativo() {
		return this.getValorTotal().compareTo(BigDecimal.ZERO) < 0;
	}

	@Transient
	public boolean isEmitido() {
		return StatusPedido.EMITIDO.equals(this.getStatus());
	}

	@Transient
	public boolean isNaoEmissivel() {
		return !this.isEmissivel();
	}

	@Transient
	public boolean isEmissivel() {
		return this.isExistente() && this.isOrcamento();
	}

	@Transient
	public boolean isEmitida() {
		return !this.isOrcamento();
	}

	@Transient
	public boolean isCancelavel() {
		return this.isExistente() && !this.isCancelado();
	}

	@Transient
	private boolean isCancelado() {
		return StatusPedido.CANCELADO.equals(this.getStatus());
	}

	@Transient
	public boolean isNaoCancelavel() {
		return !this.isCancelavel();
	}

	@Transient
	public boolean isCancelada() {
		return this.isCancelado();
	}

	@Transient
	public boolean isAlteravel() {
		return this.isOrcamento();
	}

	@Transient
	public boolean isNaoAlteravel() {
		return !this.isAlteravel();
	}

}
