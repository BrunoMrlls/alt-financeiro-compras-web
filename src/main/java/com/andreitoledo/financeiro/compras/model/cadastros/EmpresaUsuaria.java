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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.andreitoledo.financeiro.compras.model.cadastros.entidade.PessoaJuridica;

@Entity
@NamedQueries({ @NamedQuery(name ="EmpresaUsuaria.buscarTodos", query = " select eu from EmpresaUsuaria eu ")
	
})
@Table(name = "empresa_usuaria")
public class EmpresaUsuaria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String nome;
	@NotNull
	@Column(name = "nome_fantasia")
	private String nomeFantasia;
	@ManyToOne
	@JoinColumn(name = "codigo_entidade")
	private PessoaJuridica entidade;	
	@ManyToOne
	@JoinColumn(name = "codigo_empresa_contabil")
	private PessoaJuridica empresaContabil;
	private String filial;
	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public PessoaJuridica getEntidade() {
		return entidade;
	}

	public void setEntidade(PessoaJuridica entidade) {
		this.entidade = entidade;
	}

	public PessoaJuridica getEmpresaContabil() {
		return empresaContabil;
	}

	public void setEmpresaContabil(PessoaJuridica empresaContabil) {
		this.empresaContabil = empresaContabil;
	}

	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
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
		EmpresaUsuaria other = (EmpresaUsuaria) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
