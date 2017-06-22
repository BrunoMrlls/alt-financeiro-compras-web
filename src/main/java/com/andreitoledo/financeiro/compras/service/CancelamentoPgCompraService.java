package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.NfCompraDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.NfCompra;
import com.andreitoledo.financeiro.compras.model.cadastros.pagamento.StatusPagamento;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class CancelamentoPgCompraService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private NfCompraDAO nfCompraDAO;

	@Transactional
	public NfCompra cancelar(NfCompra nfCompra) throws NegocioException {
		nfCompra = this.nfCompraDAO.buscarPeloCodigo(nfCompra.getCodigo());

		/*não cancela com status CANCELADO*/
		if (nfCompra.isNaoCancelavelPagamento()) {
			throw new NegocioException(
					"Pagamento não pode ser cancelado no status "
							+ nfCompra.getStatusPgto().getDescricao() + ".");
		}
		
		/*não cancela com status PENDENTE*/
		if (nfCompra.isNaoCancelavelPagamentoPendente()) {
			throw new NegocioException(
					"Pagamento não pode ser cancelado no status "
							+ nfCompra.getStatusPgto().getDescricao() + ".");
		}
		
		if (nfCompra.isCancelavelPagamento()) {
			nfCompra.setDataCancelamentoPagamento(new Date());			
		}

		nfCompra.setStatusPgto(StatusPagamento.CANCELADO);

		this.nfCompraDAO.salvar(nfCompra);

		return nfCompra; 

	}

}
