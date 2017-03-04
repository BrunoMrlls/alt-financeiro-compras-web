package com.andreitoledo.financeiro.compras.model.cadastros.produto;

public enum TipoSazonalidade {
	
	NAO("NÃO"),
	VERAO("VERÃO"),
	CARNAVAL("CARNAVAL"),	
	VOLTAAULAS("VOLTA ÀS AULAS"),
	OUTONO("OUTONO"),
	PASCOA("PÁSCOA"),
	DIAMAES("DIA DAS MÃES"),
	INVERNO("INVERNO"),
	DIAPAIS("DIA DOS PAIS"),
	DIACRIANCAS("DIA DAS CRIANÇAS"),
	PRIMAVERA("PRIMAVERA"),
	NATAL("NATAL"),
	ANONOVO("ANO NOVO");
	
	private String descricao;
	
	TipoSazonalidade(String descricao){
		this.descricao = descricao;		
	}

	public String getDescricao() {
		return descricao;
	}	

}
