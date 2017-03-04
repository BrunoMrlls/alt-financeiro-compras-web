package com.andreitoledo.financeiro.compras.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.financeiro.compras.dao.UnidadeMedidaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.UnidadeMedida;

@FacesConverter(forClass=UnidadeMedida.class)
public class UnidadeMedidaConverter implements Converter{
	
	@Inject
	private UnidadeMedidaDAO unidadeMedidaDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		UnidadeMedida retorno = null;
		
		if (StringUtils.isNotEmpty(value)) {
			retorno = this.unidadeMedidaDAO.buscarPeloCodigo(new Long(value)); 
			
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent componet, Object value) {
		
		if(value != null){
			Long codigo = ((UnidadeMedida) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
			
		}

		return "";
	}

}
