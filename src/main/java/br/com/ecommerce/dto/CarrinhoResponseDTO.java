package br.com.ecommerce.dto;

import br.com.ecommerce.entity.Carrinho;

public class CarrinhoResponseDTO {
		
	private String nomeProduto;
    private Long idPedido;
    private Integer quantidade;
    private Double valor;
    private Double subtotal;
    
       
	public CarrinhoResponseDTO() {
		super();
	}
	
	public CarrinhoResponseDTO(Carrinho carrinho) {
		this.idPedido = carrinho.getId();
		this.nomeProduto = carrinho.getProduto().getNome();
		this.quantidade = carrinho.getQuantidade();
		this.valor = carrinho.getValorVenda();
		this.subtotal = carrinho.getSubTotal();
	
	}
	
	
	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
    
    
}
