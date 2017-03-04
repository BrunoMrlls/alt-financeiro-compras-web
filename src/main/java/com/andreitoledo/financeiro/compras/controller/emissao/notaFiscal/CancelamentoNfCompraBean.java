package com.andreitoledo.financeiro.compras.controller.emissao.notaFiscal;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.NfCompra;
import com.andreitoledo.financeiro.compras.service.CancelamentoNfCompraService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@RequestScoped
public class CancelamentoNfCompraBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CancelamentoNfCompraService cancelamentoNfCompraService;

	@Inject
	private Event<PedidoAlteradoNfCompraEvent> pedidoAlteradoEvent;

	@Inject
	private FacesMessages facesMessages;

	@Inject
	@PedidoEdicao
	private NfCompra nfCompra;

	public void cancelarPedido() {
		try {
			this.nfCompra = this.cancelamentoNfCompraService
					.cancelar(this.nfCompra);
			this.pedidoAlteradoEvent.fire(new PedidoAlteradoNfCompraEvent(
					this.nfCompra));

			facesMessages.info("Nota de compra cancelada com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

}
