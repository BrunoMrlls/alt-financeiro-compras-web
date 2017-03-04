package com.andreitoledo.financeiro.compras.model.cadastros.produto;

public enum TipoPreco {

	LIBERADO("PREÇO LIBERADO"), 
	TABELADO("PREÇO TABELADO");

	private String descricao;

	TipoPreco(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
