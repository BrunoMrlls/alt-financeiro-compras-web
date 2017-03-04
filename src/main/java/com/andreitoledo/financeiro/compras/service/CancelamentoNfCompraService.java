package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.NfCompraDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.NfCompra;
import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.StatusPedido;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CancelamentoNfCompraService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private NfCompraDAO nfCompraDAO;

	@Transactional
	public NfCompra cancelar(NfCompra nfCompra) throws NegocioException {
		nfCompra = this.nfCompraDAO.buscarPeloCodigo(nfCompra.getCodigo());

		if (nfCompra.isNaoCancelavel()) {
			throw new NegocioException(
					"Pedido não pode ser cancelado no status "
							+ nfCompra.getStatus().getDescricao() + ".");
		}
		
		if (nfCompra.isCancelavel()) {
			nfCompra.setDataCancelamento(new Date());			
		}

		nfCompra.setStatus(StatusPedido.CANCELADO);

		this.nfCompraDAO.salvar(nfCompra);

		return nfCompra; 

	}

}
