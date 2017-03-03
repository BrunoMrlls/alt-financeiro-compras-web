package com.andreitoledo.financeiro.compras.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.financeiro.compras.dao.TipoObjetoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.TipoObjeto;

@FacesConverter(forClass=TipoObjeto.class)
public class TipoObjetoConverter implements Converter{
	
	@Inject
	private TipoObjetoDAO tipoObjetoDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TipoObjeto retorno = null;
		
		if(StringUtils.isNotEmpty(value)){
			retorno = this.tipoObjetoDAO.buscarPeloCodigo(new Long (value));	
			
		}		

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((TipoObjeto) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}

}
