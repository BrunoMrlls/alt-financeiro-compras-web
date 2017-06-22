package com.br.andreitoledo.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.NfCompra;

public class TestesJpql {

	private static EntityManagerFactory factory;
	private EntityManager manager;

	@BeforeClass
	// executa uma vez antes de começar os testes
	public static void init() {
		factory = Persistence.createEntityManagerFactory("financeiroPU");
	}

	@Before
	// antes de cada metodo inicializa o entitymanager
	public void SetUp() {
		this.manager = factory.createEntityManager();
	}

	@After
	// depois de cada metodo fecha o entitymanager
	public void tearDown() {
		this.manager.close();
	}

	/* início dos testes */
	
	
	
	@Test
	public void BuscarNfCompraStatusEmitido() {
		TypedQuery<NfCompra> query = manager.createQuery(" select nfc from NfCompra nfc where nfc.status = 'EMITIDO' ",
				NfCompra.class);
		List<NfCompra> statusNfcompra = query.getResultList();

		for (NfCompra status : statusNfcompra) {
			System.out.println(status.getStatus().getDescricao());
		}

	}
	
	@Test
	public void BuscarNfCompraPorUf() {
		TypedQuery<NfCompra> query = manager.createQuery(" select nfc from NfCompra nfc where nfc.uf = 'SP' ",
				NfCompra.class);
		List<NfCompra> ufNfcompra = query.getResultList();

		for (NfCompra uf : ufNfcompra) {
			System.out.println(uf.getUf());
		}

	}
	
	
	
	

}
