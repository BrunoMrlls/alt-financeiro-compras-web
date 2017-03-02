package com.andreitoledo.financeiro.compras.model.cadastros.entidade;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Vendedor.buscarTodos", query = " select v from Vendedor v "
		+ " left join fetch v.funcionario ")

})
@Table(name = "vendedor")
@DiscriminatorValue("VENDEDOR")
public class Vendedor extends Entidade {

	private static final long serialVersionUID = 1L;
	
	private Boolean supervisor;
	private Boolean cadastroAtivo;
	@ManyToOne
	@JoinColumn(name = "codigo_funcionario")
	private Funcionario funcionario;

	public Boolean getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Boolean supervisor) {
		this.supervisor = supervisor;
	}

	public Boolean getCadastroAtivo() {
		return cadastroAtivo;
	}

	public void setCadastroAtivo(Boolean cadastroAtivo) {
		this.cadastroAtivo = cadastroAtivo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
