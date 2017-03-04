package com.andreitoledo.financeiro.compras.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.financeiro.compras.dao.NfCompraDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.NfCompra;

@FacesConverter(forClass = NfCompra.class)
public class NfCompraConverter implements Converter {

	@Inject
	private NfCompraDAO nfCompraDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		NfCompra retorno = null;

		if (StringUtils.isNotEmpty(value)) {

			retorno = this.nfCompraDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		if (value != null) {

			Long codigo = ((NfCompra) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
