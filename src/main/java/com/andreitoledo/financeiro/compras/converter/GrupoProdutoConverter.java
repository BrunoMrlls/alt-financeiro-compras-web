package com.andreitoledo.financeiro.compras.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.financeiro.compras.dao.GrupoProdutoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.GrupoProduto;

@FacesConverter(forClass = GrupoProduto.class)
public class GrupoProdutoConverter implements Converter {	

	@Inject
	private GrupoProdutoDAO grupoProdutoDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		GrupoProduto retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.grupoProdutoDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Long codigo = ((GrupoProduto) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}

}
