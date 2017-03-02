package com.andreitoledo.financeiro.compras.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.financeiro.compras.dao.ClassifEntidadeDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.ClassifEntidade;

@FacesConverter(forClass = ClassifEntidade.class)
public class ClassifEntidadeConverter implements Converter {

	@Inject
	private ClassifEntidadeDAO classifEntidadeDAO;	

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		ClassifEntidade retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.classifEntidadeDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Long codigo = ((ClassifEntidade) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}
}
