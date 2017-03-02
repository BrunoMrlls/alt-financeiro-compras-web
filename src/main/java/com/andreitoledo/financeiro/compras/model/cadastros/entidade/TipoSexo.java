package com.andreitoledo.financeiro.compras.model.cadastros.entidade;

public enum TipoSexo {

	MASCULINO("MASCULINO"), 
	FEMININO("FEMININO");

	private String descricao;

	TipoSexo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
