package com.andreitoledo.financeiro.compras.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.financeiro.compras.dao.SecaoProdutoDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.produto.SecaoProduto;

@FacesConverter(forClass = SecaoProduto.class)
public class SecaoProdutoConverter implements Converter {

	@Inject
	private SecaoProdutoDAO secaoProdutoDAO;	

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		SecaoProduto retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.secaoProdutoDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Long codigo = ((SecaoProduto) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}

}
