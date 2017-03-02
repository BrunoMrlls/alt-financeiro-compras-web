package com.andreitoledo.financeiro.compras.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.financeiro.compras.dao.OutroCredorDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.OutroCredor;

@FacesConverter(forClass = OutroCredor.class)
public class OutroCredorConverter implements Converter {

	@Inject
	private OutroCredorDAO outroCredorDAO;	

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		OutroCredor retorno = null;
		
		if (StringUtils.isNotEmpty(value)) {
			retorno = this.outroCredorDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		
		if (value != null) {
			Long codigo = ((OutroCredor) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
