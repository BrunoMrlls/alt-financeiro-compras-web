package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.NfCompraDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.NfCompra;
import com.andreitoledo.financeiro.compras.model.cadastros.pagamento.StatusPagamento;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class EmissaoPagamentoPgCompraService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroPgCompraService cadastroPgCompraService;

	@Inject
	private NfCompraDAO nfCompraDAO;

	@Transactional
	public NfCompra emitir(NfCompra nfCompra) throws NegocioException {
		nfCompra = this.cadastroPgCompraService.salvar(nfCompra);		

		if (nfCompra.isNaoPagavel()) {
			throw new NegocioException(
					"Pedido não pode ser pago com status "
							+ nfCompra.getStatusPgto().getDescricao() + ".");
		}

		/* setando a data de pagamento */
		if (nfCompra.isPagavel()) {
			nfCompra.setDataPagamento(new Date());
		}

		nfCompra.setStatusPgto(StatusPagamento.PAGO);

		this.nfCompraDAO.salvar(nfCompra);

		return nfCompra;

	}

}
