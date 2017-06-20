package com.andreitoledo.financeiro.compras.controller.financ.pagamentos;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.controller.emissao.notaFiscal.PedidoAlteradoNfCompraEvent;
import com.andreitoledo.financeiro.compras.controller.emissao.notaFiscal.PedidoEdicao;
import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.NfCompra;
import com.andreitoledo.financeiro.compras.service.EmissaoPagamentoPgCompraService;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@RequestScoped
public class EmissaoPedidoPgCompraBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmissaoPagamentoPgCompraService emissaoPagamentoPgCompraService;

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
			this.nfCompra = this.emissaoPagamentoPgCompraService
					.emitir(this.nfCompra);
			this.pedidoAlteradoNfCompraEvent
			.fire(new PedidoAlteradoNfCompraEvent(this.nfCompra));			
			
			facesMessages.info("Nota de compra paga com sucesso.");

		} catch (NegocioException e) {

			facesMessages.error(e.getMessage());

		} finally {
			this.nfCompra.adicionarItemVazio();
		}
	}

}
