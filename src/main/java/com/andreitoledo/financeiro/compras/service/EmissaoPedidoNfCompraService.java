package com.andreitoledo.financeiro.compras.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.andreitoledo.financeiro.compras.dao.NfCompraDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.NfCompra;
import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.StatusPedido;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class EmissaoPedidoNfCompraService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroNfCompraService cadastroNfCompraService;

	@Inject
	private NfCompraDAO nfCompraDAO;

	@Transactional
	public NfCompra emitir(NfCompra nfCompra) throws NegocioException {
		nfCompra = this.cadastroNfCompraService.salvar(nfCompra);

		if (nfCompra.isNaoEmissivel()) {
			throw new NegocioException(
					"Pedido não pode ser emitido com status "
							+ nfCompra.getStatus().getDescricao() + ".");
		}

		if (nfCompra.isEmissivel()) {
			nfCompra.setDataEmissao(new Date());
		}

		nfCompra.setStatus(StatusPedido.EMITIDO);

		this.nfCompraDAO.salvar(nfCompra);

		return nfCompra;

	}

}
