package com.andreitoledo.financeiro.compras.model.cadastros.pagamento;

public enum StatusPagamento {

	PENDENTE("PENDENTE"), 
	PAGO("PAGO"), 
	CANCELADO("CANCELADO");

	private String descricao;	

	StatusPagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}	

}
