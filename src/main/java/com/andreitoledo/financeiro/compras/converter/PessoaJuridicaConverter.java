package com.andreitoledo.financeiro.compras.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.financeiro.compras.dao.PessoaJuridicaDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.entidade.PessoaJuridica;

@FacesConverter(forClass=PessoaJuridica.class)
public class PessoaJuridicaConverter implements Converter{
	
	@Inject
	private PessoaJuridicaDAO pessoaJuridicaDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		PessoaJuridica retorno = null;
		
		if (StringUtils.isNotEmpty(value)) {
			retorno = this.pessoaJuridicaDAO.buscarPeloCodigo(new Long(value));
			
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			Long codigo = ((PessoaJuridica) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
			
		}

		return "";
	}

}
