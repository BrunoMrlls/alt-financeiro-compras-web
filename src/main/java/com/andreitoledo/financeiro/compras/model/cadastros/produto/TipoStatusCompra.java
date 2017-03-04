package com.andreitoledo.financeiro.compras.model.cadastros.produto;

public enum TipoStatusCompra {

	ATIVO("ATIVO"), 
	INATIVO("INATIVO");

	private String descricao;

	TipoStatusCompra(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
