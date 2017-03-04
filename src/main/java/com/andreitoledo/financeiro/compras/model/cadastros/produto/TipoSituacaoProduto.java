package com.andreitoledo.financeiro.compras.model.cadastros.produto;

public enum TipoSituacaoProduto {
	
	NORMAL("NORMAL"),
	DESATIVADO("DESATIVADO");	
	
	private String descricao;
	
	TipoSituacaoProduto(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
