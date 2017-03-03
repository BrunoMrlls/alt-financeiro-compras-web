package com.andreitoledo.financeiro.compras.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.financeiro.compras.dao.EmpresaUsuariaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.EmpresaUsuaria;

@FacesConverter(forClass=EmpresaUsuaria.class)
public class EmpresaUsuariaConverter implements Converter {
	
	@Inject
	private EmpresaUsuariaDAO empresaUsuariaDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		EmpresaUsuaria retorno =  null;
		
		if(StringUtils.isNotEmpty(value)){
			retorno = empresaUsuariaDAO.buscarPeloCodigo(new Long(value));			
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			Long codigo = ((EmpresaUsuaria) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
			
		}
		
		return "";
		
	}

}
