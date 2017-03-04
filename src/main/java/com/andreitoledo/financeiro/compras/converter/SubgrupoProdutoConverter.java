package com.andreitoledo.financeiro.compras.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.financeiro.compras.dao.SubgrupoProdutoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.SubgrupoProduto;

@FacesConverter(forClass = SubgrupoProduto.class)
public class SubgrupoProdutoConverter implements Converter {

	@Inject
	private SubgrupoProdutoDAO subgrupoProdutoDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		SubgrupoProduto retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.subgrupoProdutoDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Long codigo = ((SubgrupoProduto) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
