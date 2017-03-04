package com.andreitoledo.financeiro.compras.controller.emissao.notaFiscal;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.NfCompra;
import com.andreitoledo.financeiro.compras.service.EmissaoPedidoNfCompraService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@RequestScoped
public class EmissaoPedidoNfCompraBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmissaoPedidoNfCompraService emissaoPedidoNfCompraService;

	@Inject
	@PedidoEdicao
	private NfCompra nfCompra;

	@Inject
	private Event<PedidoAlteradoNfCompraEvent> pedidoAlteradoNfCompraEvent;

	@Inject
	private FacesMessages facesMessages;

	public void emitirPedido() {
		this.nfCompra.removerItemVazio();

		try {
			this.nfCompra = this.emissaoPedidoNfCompraService
					.emitir(this.nfCompra);
			this.pedidoAlteradoNfCompraEvent
					.fire(new PedidoAlteradoNfCompraEvent(this.nfCompra));

			facesMessages.info("Nota de compra emitida com sucesso.");

		} catch (NegocioException e) {

			facesMessages.error(e.getMessage());

		} finally {
			this.nfCompra.adicionarItemVazio();
		}
	}

}
