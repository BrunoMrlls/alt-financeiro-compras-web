package com.andreitoledo.financeiro.compras.model.cadastros;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "ContaBancaria.buscarTodos", query = "select cb from ContaBancaria cb "
		+ " left join fetch cb.banco "
		+ " left join fetch cb.empresa "
		+ " left join fetch cb.sacadorAvalista ") })
public class ContaBancaria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "codigo_banco")
	private Banco banco;

	@ManyToOne
	@JoinColumn(name = "codigo_empresa")
	private EmpresaUsuaria empresa;

	@ManyToOne
	@JoinColumn(name = "codigo_sacador_avalista")
	private EmpresaUsuaria sacadorAvalista;

	private String agencia;
	@Column(name = "digito_agencia")
	private String digitoAgencia;
	@Column(name = "conta_corrente")
	private String contaCorrente;
	@Column(name = "digito_conta")
	private String digitoConta;
	@Column(name = "cadastro_ativo")
	private Boolean cadastroAtivo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao == null ? null : descricao.toUpperCase();
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public EmpresaUsuaria getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaUsuaria empresa) {
		this.empresa = empresa;
	}

	public EmpresaUsuaria getSacadorAvalista() {
		return sacadorAvalista;
	}

	public void setSacadorAvalista(EmpresaUsuaria sacadorAvalista) {
		this.sacadorAvalista = sacadorAvalista;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getDigitoAgencia() {
		return digitoAgencia;
	}

	public void setDigitoAgencia(String digitoAgencia) {
		this.digitoAgencia = digitoAgencia;
	}

	public String getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public String getDigitoConta() {
		return digitoConta;
	}

	public void setDigitoConta(String digitoConta) {
		this.digitoConta = digitoConta;
	}

	public Boolean getCadastroAtivo() {
		return cadastroAtivo;
	}

	public void setCadastroAtivo(Boolean cadastroAtivo) {
		this.cadastroAtivo = cadastroAtivo;
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
		ContaBancaria other = (ContaBancaria) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
