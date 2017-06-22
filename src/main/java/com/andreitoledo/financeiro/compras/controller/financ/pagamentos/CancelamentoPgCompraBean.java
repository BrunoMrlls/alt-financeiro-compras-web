package com.andreitoledo.financeiro.compras.controller.financ.pagamentos;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.controller.emissao.notaFiscal.PedidoAlteradoNfCompraEvent;
import com.andreitoledo.financeiro.compras.controller.emissao.notaFiscal.PedidoEdicao;
import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.NfCompra;
import com.andreitoledo.financeiro.compras.service.CancelamentoPgCompraService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@RequestScoped
public class CancelamentoPgCompraBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CancelamentoPgCompraService cancelamentoPgCompraService;

	@Inject
	private Event<PedidoAlteradoNfCompraEvent> pedidoAlteradoEvent;

	@Inject
	private FacesMessages facesMessages;

	@Inject
	@PedidoEdicao
	private NfCompra nfCompra;

	public void cancelarPedido() {
		try {
			this.nfCompra = this.cancelamentoPgCompraService
					.cancelar(this.nfCompra);
			this.pedidoAlteradoEvent.fire(new PedidoAlteradoNfCompraEvent(
					this.nfCompra));

			facesMessages.info("Pagamento cancelado com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

}
