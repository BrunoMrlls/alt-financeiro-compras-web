package com.andreitoledo.financeiro.compras.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.financeiro.compras.dao.DepartamentoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.Departamento;

@FacesConverter(forClass=Departamento.class)
public class DepartamentoConverter implements Converter{
	
	@Inject
	private DepartamentoDAO departamentoDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Departamento retorno = null;
		
		if (StringUtils.isNotEmpty(value)) {
			retorno = this.departamentoDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Departamento) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}
