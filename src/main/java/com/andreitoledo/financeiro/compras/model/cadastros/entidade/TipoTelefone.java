package com.andreitoledo.financeiro.compras.model.cadastros.entidade;

public enum TipoTelefone {

	CELULAR("CELULAR"), 
	RESIDENCIAL("RESIDENCIAL"), 
	COMERCIAL("COMERCIAL"), 
	CONTATO("CONTATO");

	private String descricao;

	private TipoTelefone(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao; 
	}

}
