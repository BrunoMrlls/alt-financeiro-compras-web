package com.br.andreitoledo.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal.NfCompra;

public class TesteCriteria {
	
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
	public void porStatusNotaCompra() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<NfCompra> criteriaQuery = builder.createQuery(NfCompra.class);

		Root<NfCompra> root = criteriaQuery.from(NfCompra.class);
		Predicate predicate = builder.equal(root.<String> get("status"), "EMITIDO");

		criteriaQuery.select(root);
		criteriaQuery.where(predicate);

		TypedQuery<NfCompra> query = manager.createQuery(criteriaQuery);
		List<NfCompra> listaStatusEmitidos = query.getResultList();

		for (NfCompra nfCompra : listaStatusEmitidos) {
			System.out.println(nfCompra.getNfNumero() + " - " + nfCompra.getStatus().getDescricao());
		}

	}


}
