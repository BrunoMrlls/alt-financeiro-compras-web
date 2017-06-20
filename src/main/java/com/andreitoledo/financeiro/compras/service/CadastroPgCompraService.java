package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.NfCompraDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.NfCompra;
import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.NfCompraItemProduto;
import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.StatusPedido;
import com.andreitoledo.financeiro.compras.model.cadastros.pagamento.StatusPagamento;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CadastroPgCompraService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private NfCompraDAO nFcompraDAO;

	@Transactional
	public NfCompra salvar(NfCompra nfCompra) throws NegocioException {
		
		/*regras de negocio aqui*/
		
		this.nFcompraDAO.salvar(nfCompra);
		return nfCompra;

	}

}
