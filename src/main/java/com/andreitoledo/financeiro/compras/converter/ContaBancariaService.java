package com.andreitoledo.financeiro.compras.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.financeiro.compras.dao.ContaBancariaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.ContaBancaria;

@FacesConverter(forClass = ContaBancaria.class)
public class ContaBancariaService implements Converter {

	@Inject
	private ContaBancariaDAO contaBancariaDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		ContaBancaria retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.contaBancariaDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		if (value != null) {
			Long codigo = ((ContaBancaria) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";

	}

}