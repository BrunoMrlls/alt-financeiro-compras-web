package com.andreitoledo.financeiro.compras.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.NfCompra;
import com.andreitoledo.financeiro.compras.service.NegocioException;
import com.andreitoledo.financeiro.compras.util.jpa.Transactional;

public class NfCompraDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public NfCompra buscarPeloCodigo(Long codigo) {
		return manager.find(NfCompra.class, codigo);

	}

	@SuppressWarnings("unchecked")
	public List<NfCompra> buscarTodos() {
		return manager.createNamedQuery("NfCompra.buscarTodos").getResultList();
	}

	public void salvar(NfCompra nfCompra) {
		manager.merge(nfCompra);
	}

	@Transactional
	public void excluir(NfCompra nfCompra) throws NegocioException {
		nfCompra = buscarPeloCodigo(nfCompra.getCodigo());

		try {
			manager.remove(nfCompra);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException(
					"Esta Nota de Compra não pode ser excluído.");

		}

	}

}
