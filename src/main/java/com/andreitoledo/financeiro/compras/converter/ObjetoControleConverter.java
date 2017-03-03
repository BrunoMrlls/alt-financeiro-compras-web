package com.andreitoledo.financeiro.compras.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.financeiro.compras.dao.ObjetoControleDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.ObjetoControle;

@FacesConverter(forClass = ObjetoControle.class)
public class ObjetoControleConverter implements Converter {

	@Inject
	private ObjetoControleDAO objetoControleDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		ObjetoControle retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.objetoControleDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Long codigo = ((ObjetoControle) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
