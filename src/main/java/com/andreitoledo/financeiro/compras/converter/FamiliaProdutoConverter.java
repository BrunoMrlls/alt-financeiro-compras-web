package com.andreitoledo.financeiro.compras.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.financeiro.compras.dao.FamiliaProdutoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.FamiliaProduto;

@FacesConverter(forClass = FamiliaProduto.class)
public class FamiliaProdutoConverter implements Converter {

	@Inject
	private FamiliaProdutoDAO familiaProdutoDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		FamiliaProduto retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.familiaProdutoDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Long codigo = ((FamiliaProduto) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
