package com.andreitoledo.financeiro.compras.model.cadastros.notaFiscal;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.andreitoledo.financeiro.compras.model.cadastros.produto.Produto;

@Entity
@NamedQueries({ @NamedQuery(name = "NfCompraItemProduto.buscarTodos", query = "select nfcp from NfCompraItemProduto nfcp  "
		+ " left join fetch nfcp.nfCompra " + " left join fetch nfcp.produto ") })
@Table(name = "nf_compra_produtos")
public class NfCompraItemProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private Integer quantidade = 1;
	@Column(name = "valor_unitario", nullable = false, precision = 10, scale = 2)
	private BigDecimal valorUnitario = BigDecimal.ZERO;

	@ManyToOne
	@JoinColumn(name = "codigo_produto", nullable = false)
	private Produto produto;
	@ManyToOne
	@JoinColumn(name = "codigo_nfcompra", nullable = false)
	private NfCompra nfCompra;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public NfCompra getNfCompra() {
		return nfCompra;
	}

	public void setNfCompra(NfCompra nfCompra) {
		this.nfCompra = nfCompra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NfCompraItemProduto other = (NfCompraItemProduto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Transient
	public boolean isProdutoAssociado() {
		return this.getProduto() != null
				&& this.getProduto().getCodigo() != null;
	}

}
