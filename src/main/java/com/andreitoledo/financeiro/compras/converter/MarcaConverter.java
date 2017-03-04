package com.andreitoledo.financeiro.compras.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.financeiro.compras.dao.MarcaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.Marca;

@FacesConverter(forClass = Marca.class)
public class MarcaConverter implements Converter {

	@Inject
	private MarcaDAO marcaDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Marca retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.marcaDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		if (value != null) {
			Long codigo = ((Marca) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
