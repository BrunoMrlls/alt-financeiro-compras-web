package com.andreitoledo.financeiro.compras.model.cadastros.entidade;

public enum TipoLogradouro {
	
	RUA("RUA"),        
	AVENIDA("AVENIDA"),    
	TRAVESSA("TRAVESSA"),   
	PARALELA("PARALELA"),   
	SUBIDA("SUBIDA"),     
	BECO("BECO"),       
	LADEIRA("LADEIRA"),    
	LARGO("LARGO"),      
	LOTE("LOTE"),       
	MORRO("MORRO"),      
	PARQUE("PARQUE"),     
	PASSAGEM("PASSAGEM"),   
	PRACA("PRAÇA"),      
	QUADRA("QUADRA"),     
	RECANTO("RECANTO"),    
	RESIDENCIAL("RESIDENCIAL"),
	RODOVIA("RODOVIA"),    
	SITIO("SÍTIO"),      
	TUNEL("TÚNEL"),      
	VALE("VALE");
	
	private String descricao;
	 
	TipoLogradouro(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
