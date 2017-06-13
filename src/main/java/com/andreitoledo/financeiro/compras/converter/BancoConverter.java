package com.andreitoledo.financeiro.compras.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.financeiro.compras.dao.BancoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.Banco;

@FacesConverter(forClass = Banco.class)
public class BancoConverter implements Converter {

	@Inject
	private BancoDAO bancoDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Banco retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.bancoDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		if (value != null) {
			Long codigo = ((Banco) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
