package com.andreitoledo.financeiro.compras.model.cadastros.produto;

public enum TipoSituacaoCadastro {

	ATIVO("ATIVO"), 
	INATIVO("INATIVO");

	private String descricao;

	TipoSituacaoCadastro(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
