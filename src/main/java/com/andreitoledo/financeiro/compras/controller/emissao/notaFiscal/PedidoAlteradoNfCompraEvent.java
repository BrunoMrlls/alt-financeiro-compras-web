package com.andreitoledo.financeiro.compras.controller.emissao.notaFiscal;

import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.NfCompra;

public class PedidoAlteradoNfCompraEvent {

	private NfCompra nfCompra;

	public PedidoAlteradoNfCompraEvent(NfCompra nfCompra) {
		this.nfCompra = nfCompra;

	}

	public NfCompra getNfCompra() {
		return nfCompra;
	}

}
