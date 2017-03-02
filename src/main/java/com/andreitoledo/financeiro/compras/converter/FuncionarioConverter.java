package com.andreitoledo.financeiro.compras.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.financeiro.compras.dao.FuncionarioDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.Funcionario;

@FacesConverter(forClass = Funcionario.class)
public class FuncionarioConverter implements Converter {

	@Inject
	private FuncionarioDAO funcionarioDAO;	

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Funcionario retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.funcionarioDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent componet,
			Object value) {
		if (value != null) {
			Long codigo = ((Funcionario) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
