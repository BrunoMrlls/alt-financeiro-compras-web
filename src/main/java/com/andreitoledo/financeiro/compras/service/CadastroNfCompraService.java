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

public class CadastroNfCompraService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private NfCompraDAO nFcompraDAO;

	@Transactional
	public NfCompra salvar(NfCompra nfCompra) throws NegocioException {
		if (nfCompra.isNovo()) {
			nfCompra.setDataCriacao(new Date());
			nfCompra.setStatus(StatusPedido.ORCAMENTO);
			nfCompra.setStatusPgto(StatusPagamento.PENDENTE);

		}

		/* fazendo o calculo quantidade * valor = valor total */

		BigDecimal valorTotal = BigDecimal.ZERO;

		if (nfCompra.getNfCompraItensProduto() != null) {
			for (NfCompraItemProduto item : nfCompra.getNfCompraItensProduto()) {
				valorTotal = valorTotal.add(item.getValorUnitario().multiply(
						new BigDecimal(item.getQuantidade())));
			}
		}

		nfCompra.setValorTotal(valorTotal);

		if (nfCompra.getCodigo() == null) {
			nfCompra.setDataMovimento(new Date());
		}

		/* validação: o pedido tem que possuir pelo menos um item */

		if (nfCompra.getNfCompraItensProduto().isEmpty()) {
			throw new NegocioException(
					"O pedido deve possuir pelo menos um item.");
		}

		/* validação: o valor total da nota não pode ser negativo */

		if (nfCompra.isValorTotalNegativo()) {
			throw new NegocioException(
					"Valor total da nota não pode ser negativo.");

		}

		this.nFcompraDAO.salvar(nfCompra);
		return nfCompra;

	}

}
