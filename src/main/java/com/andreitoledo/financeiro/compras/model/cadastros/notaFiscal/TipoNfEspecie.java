package com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal;

public enum TipoNfEspecie {
	
	NFS("Nota Fiscal de Serviço"),
	NFF("Nota Fiscal de Fatura"),
	NFE("Nota Fiscal Eletrônica"),
	NF("Nota Fiscal"),
	M1("Modelo 1"),
	CNT("Conhecimento de Transporte");
	
	private String descricao;	

	TipoNfEspecie(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
