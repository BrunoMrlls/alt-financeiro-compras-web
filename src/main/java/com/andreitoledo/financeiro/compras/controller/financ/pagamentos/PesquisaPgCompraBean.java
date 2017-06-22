package com.andreitoledo.financeiro.compras.controller.financ.pagamentos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andreitoledo.financeiro.compras.dao.NfCompraDAO;
import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.NfCompra;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaPgCompraBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	NfCompraDAO nfCompraDAO;

	private NfCompra nfCompraSelecionado;

	private List<NfCompra> nfCompras = new ArrayList<>();

	@Inject
	private FacesMessages facesMessages;

	public List<NfCompra> getNfCompras() {
		return nfCompras;
	}

	@PostConstruct
	public void inicializar() {
		this.nfCompras = this.nfCompraDAO.buscarNfcompraPorStatusEmitido();
	}

	public void excluir() {
		try {
			nfCompraDAO.excluir(nfCompraSelecionado);
			this.nfCompras.remove(nfCompraSelecionado);
			facesMessages.info("Nota de Compra " + nfCompraSelecionado.getCodigo() + " excluído com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}
	}

	public NfCompra getNfCompraSelecionado() {
		return nfCompraSelecionado;
	}

	public void setNfCompraSelecionado(NfCompra nfCompraSelecionado) {
		this.nfCompraSelecionado = nfCompraSelecionado;
	}

}
