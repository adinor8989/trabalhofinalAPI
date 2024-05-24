package br.com.ecommerce.dto;

import br.com.ecommerce.entity.Produto;


public class PedidoResponseDTO {
	
	private Long id;
	private ClienteResponseDTO cliente;
	private String status;
	private Produto produtos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ClienteResponseDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteResponseDTO cliente) {
		this.cliente = cliente;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Produto getProdutos() {
		return produtos;
	}
	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
	}
	
	
}
