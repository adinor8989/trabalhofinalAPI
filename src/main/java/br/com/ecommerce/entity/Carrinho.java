package br.com.ecommerce.entity;

import br.com.ecommerce.dto.CarrinhoRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Carrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	@NotNull
	@Min(value = 1, message = "A quantidade deve ser pelo menos 1")
	private Integer quantidade;

	@NotNull
	@DecimalMin(value = "0.01", message = "O valor de venda deve ser maior que zero")
	private Double valorVenda;

	@NotNull
	@DecimalMin(value = "0.01", message = "O subtotal deve ser maior que zero")
	private Double subTotal;
	
	

	public Carrinho() {
		super();
	}

	public Carrinho(CarrinhoRequestDTO carrinho, Pedido pedido,Produto produto) {
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = carrinho.getQuantidade();
		this.valorVenda = carrinho.getValor();
		this.subTotal = carrinho.getQuantidade() * carrinho.getValor();		
	
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
