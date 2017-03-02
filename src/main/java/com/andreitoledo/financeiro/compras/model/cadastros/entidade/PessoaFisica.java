package com.andreitoledo.financeiro.compras.model.cadastros.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "PessoaFisica.buscarTodos", query = " select pf from PessoaFisica pf "
		+ " left join fetch pf.classifEntidade ")

})
@Table(name = "pessoafisica")
@DiscriminatorValue("PESSOA_FISICA")
public class PessoaFisica extends Entidade{

	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name = "nome_fantasia")
	private String nomeFantasia;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_estado_civil")
	private TipoEstadoCivil tipoEstadoCivil;
	@Column(name = "inscricao_federal")
	private String inscricaoFederal; // CPF
	@Column(name = "inscricao_estadual")
	private String inscricaoEstadual; // RG
	@Column(name = "inscricao_estrangeiro")
	private String inscricaoEstrangeiro;
	@Column(name = "cadastro_ativo")
	private Boolean cadastroAtivo;
	@ManyToOne
	@JoinColumn(name = "codigo_classifEntidade")
	private ClassifEntidade classifEntidade;

	/* endereco estabelecimento */

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_log_estabelecimento")
	private TipoLogradouro tipoLogradouro;
	@Column(name = "logradouro_estabelecimento")
	private String logradouro;
	@Column(name = "numero_estabelecimento")
	private String numero;
	@Column(name = "complemento_estabelecimento")
	private String complemento;
	@Column(name = "bairro_estabelecimento")
	private String bairro;
	@Column(name = "cep_estabelecimento")
	private String cep;
	@Column(name = "cidade_estabelecimento")
	private String cidade;
	@Column(name = "uf_estabelecimento")
	private String uf;
	@Column(name = "pais_estabelecimento")
	private String pais;

	/* endereco cobranca */
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_log_cobranca")
	private TipoLogradouro tipoLogradouroCobranca;
	@Column(name = "logradouro_cobranca")
	private String logradouroCobranca;
	@Column(name = "numero_cobranca")
	private String numeroCobranca;
	@Column(name = "complemento_cobranca")
	private String complementoCobranca;
	@Column(name = "bairro_cobranca")
	private String bairroCobranca;
	@Column(name = "cep_cobranca")
	private String cepCobranca;
	@Column(name = "cidade_cobranca")
	private String cidadeCobranca;
	@Column(name = "uf_cobranca")
	private String ufCobranca;
	@Column(name = "pais_cobranca")
	private String paisCobranca;

	/* endereco entrega */

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_log_entrega")
	private TipoLogradouro tipoLogradouroEntrega;
	@Column(name = "logradouro_entrega")
	private String logradouroEntrega;
	@Column(name = "numero_entrega")
	private String numeroEntrega;
	@Column(name = "complemento_entrega")
	private String complementoEntrega;
	@Column(name = "bairro_entrega")
	private String bairroEntrega;
	@Column(name = "cep_entrega")
	private String cepEntrega;
	@Column(name = "cidade_entrega")
	private String cidadeEntrega;
	@Column(name = "uf_entrega")
	private String ufEntrega;
	@Column(name = "pais_entrega")
	private String paisEntrega;

	/* contatos */

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_telefone1")
	private TipoTelefone tipoTelefone1;
	private String ddd1;
	@Column(name = "numero_tel1")
	private String numeroTel1;
	private String contato1;
	private String email1;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_telefone2")
	private TipoTelefone tipoTelefone2;
	private String ddd2;
	@Column(name = "numero_tel2")
	private String numeroTel2;
	private String contato2;
	private String email2;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_telefone3")
	private TipoTelefone tipoTelefone3;
	private String ddd3;
	@Column(name = "numero_tel3")
	private String numeroTel3;
	private String contato3;
	private String email3;

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public TipoEstadoCivil getTipoEstadoCivil() {
		return tipoEstadoCivil;
	}

	public void setTipoEstadoCivil(TipoEstadoCivil tipoEstadoCivil) {
		this.tipoEstadoCivil = tipoEstadoCivil;
	}

	public String getInscricaoFederal() {
		return inscricaoFederal;
	}

	public void setInscricaoFederal(String inscricaoFederal) {
		this.inscricaoFederal = inscricaoFederal;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoEstrangeiro() {
		return inscricaoEstrangeiro;
	}

	public void setInscricaoEstrangeiro(String inscricaoEstrangeiro) {
		this.inscricaoEstrangeiro = inscricaoEstrangeiro;
	}

	public Boolean getCadastroAtivo() {
		return cadastroAtivo;
	}

	public void setCadastroAtivo(Boolean cadastroAtivo) {
		this.cadastroAtivo = cadastroAtivo;
	}

	public ClassifEntidade getClassifEntidade() {
		return classifEntidade;
	}

	public void setClassifEntidade(ClassifEntidade classifEntidade) {
		this.classifEntidade = classifEntidade;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
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
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
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
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public TipoLogradouro getTipoLogradouroCobranca() {
		return tipoLogradouroCobranca;
	}

	public void setTipoLogradouroCobranca(TipoLogradouro tipoLogradouroCobranca) {
		this.tipoLogradouroCobranca = tipoLogradouroCobranca;
	}

	public String getLogradouroCobranca() {
		return logradouroCobranca;
	}

	public void setLogradouroCobranca(String logradouroCobranca) {
		this.logradouroCobranca = logradouroCobranca;
	}

	public String getNumeroCobranca() {
		return numeroCobranca;
	}

	public void setNumeroCobranca(String numeroCobranca) {
		this.numeroCobranca = numeroCobranca;
	}

	public String getComplementoCobranca() {
		return complementoCobranca;
	}

	public void setComplementoCobranca(String complementoCobranca) {
		this.complementoCobranca = complementoCobranca;
	}

	public String getBairroCobranca() {
		return bairroCobranca;
	}

	public void setBairroCobranca(String bairroCobranca) {
		this.bairroCobranca = bairroCobranca;
	}

	public String getCepCobranca() {
		return cepCobranca;
	}

	public void setCepCobranca(String cepCobranca) {
		this.cepCobranca = cepCobranca;
	}

	public String getCidadeCobranca() {
		return cidadeCobranca;
	}

	public void setCidadeCobranca(String cidadeCobranca) {
		this.cidadeCobranca = cidadeCobranca;
	}

	public String getUfCobranca() {
		return ufCobranca;
	}

	public void setUfCobranca(String ufCobranca) {
		this.ufCobranca = ufCobranca;
	}

	public String getPaisCobranca() {
		return paisCobranca;
	}

	public void setPaisCobranca(String paisCobranca) {
		this.paisCobranca = paisCobranca;
	}

	public TipoLogradouro getTipoLogradouroEntrega() {
		return tipoLogradouroEntrega;
	}

	public void setTipoLogradouroEntrega(TipoLogradouro tipoLogradouroEntrega) {
		this.tipoLogradouroEntrega = tipoLogradouroEntrega;
	}

	public String getLogradouroEntrega() {
		return logradouroEntrega;
	}

	public void setLogradouroEntrega(String logradouroEntrega) {
		this.logradouroEntrega = logradouroEntrega;
	}

	public String getNumeroEntrega() {
		return numeroEntrega;
	}

	public void setNumeroEntrega(String numeroEntrega) {
		this.numeroEntrega = numeroEntrega;
	}

	public String getComplementoEntrega() {
		return complementoEntrega;
	}

	public void setComplementoEntrega(String complementoEntrega) {
		this.complementoEntrega = complementoEntrega;
	}

	public String getBairroEntrega() {
		return bairroEntrega;
	}

	public void setBairroEntrega(String bairroEntrega) {
		this.bairroEntrega = bairroEntrega;
	}

	public String getCepEntrega() {
		return cepEntrega;
	}

	public void setCepEntrega(String cepEntrega) {
		this.cepEntrega = cepEntrega;
	}

	public String getCidadeEntrega() {
		return cidadeEntrega;
	}

	public void setCidadeEntrega(String cidadeEntrega) {
		this.cidadeEntrega = cidadeEntrega;
	}

	public String getUfEntrega() {
		return ufEntrega;
	}

	public void setUfEntrega(String ufEntrega) {
		this.ufEntrega = ufEntrega;
	}

	public String getPaisEntrega() {
		return paisEntrega;
	}

	public void setPaisEntrega(String paisEntrega) {
		this.paisEntrega = paisEntrega;
	}

	public TipoTelefone getTipoTelefone1() {
		return tipoTelefone1;
	}

	public void setTipoTelefone1(TipoTelefone tipoTelefone1) {
		this.tipoTelefone1 = tipoTelefone1;
	}

	public String getDdd1() {
		return ddd1;
	}

	public void setDdd1(String ddd1) {
		this.ddd1 = ddd1;
	}

	public String getNumeroTel1() {
		return numeroTel1;
	}

	public void setNumeroTel1(String numeroTel1) {
		this.numeroTel1 = numeroTel1;
	}

	public String getContato1() {
		return contato1;
	}

	public void setContato1(String contato1) {
		this.contato1 = contato1;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public TipoTelefone getTipoTelefone2() {
		return tipoTelefone2;
	}

	public void setTipoTelefone2(TipoTelefone tipoTelefone2) {
		this.tipoTelefone2 = tipoTelefone2;
	}

	public String getDdd2() {
		return ddd2;
	}

	public void setDdd2(String ddd2) {
		this.ddd2 = ddd2;
	}

	public String getNumeroTel2() {
		return numeroTel2;
	}

	public void setNumeroTel2(String numeroTel2) {
		this.numeroTel2 = numeroTel2;
	}

	public String getContato2() {
		return contato2;
	}

	public void setContato2(String contato2) {
		this.contato2 = contato2;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public TipoTelefone getTipoTelefone3() {
		return tipoTelefone3;
	}

	public void setTipoTelefone3(TipoTelefone tipoTelefone3) {
		this.tipoTelefone3 = tipoTelefone3;
	}

	public String getDdd3() {
		return ddd3;
	}

	public void setDdd3(String ddd3) {
		this.ddd3 = ddd3;
	}

	public String getNumeroTel3() {
		return numeroTel3;
	}

	public void setNumeroTel3(String numeroTel3) {
		this.numeroTel3 = numeroTel3;
	}

	public String getContato3() {
		return contato3;
	}

	public void setContato3(String contato3) {
		this.contato3 = contato3;
	}

	public String getEmail3() {
		return email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

}
