package com.andreitoledo.financeiro.compras.model.cadastros.entidade;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "outrocredor")
@DiscriminatorValue("OUTRO_CREDOR")
public class OutroCredor extends Entidade{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "nome_fantasia")
	private String nomeFantasia;	
	@Column(name = "cadastro_ativo")
	private Boolean cadastroAtivo;
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public Boolean getCadastroAtivo() {
		return cadastroAtivo;
	}
	public void setCadastroAtivo(Boolean cadastroAtivo) {
		this.cadastroAtivo = cadastroAtivo;
	}

}
