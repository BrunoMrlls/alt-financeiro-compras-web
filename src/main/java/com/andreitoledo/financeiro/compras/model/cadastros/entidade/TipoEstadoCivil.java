package com.andreitoledo.financeiro.compras.model.cadastros.entidade;

public enum TipoEstadoCivil {
	
	SOLTEIRO("SOLTEIRO(a)"),
	CASADO("CASADO(a)"),
	SEPARADO("SEPARADO(a)"),
	DIVORCIADO("DIVORCIADO(a)"),
	VIUVO("VIUVO(a)"),
	COMPANHEIRO("COMPANHEIRO(a)");
	
	public String descricao;
	
	TipoEstadoCivil(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
