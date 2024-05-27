package br.com.ecommerce.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.ecommerce.entity.Carrinho;
import br.com.ecommerce.entity.Cliente;
import br.com.ecommerce.entity.Pedido;



public class PedidoResponseDTO {
	
	private Long id;
	private Cliente cliente;
	private LocalDate data;
	private String status;
    private List<Carrinho> carrinho;

    
	public List<Carrinho> getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(List<Carrinho> carrinho) {
		this.carrinho = carrinho;
	}
	public PedidoResponseDTO(PedidoResponseDTO pedido) {
        this.status = pedido.getStatus();
        this.setData(pedido.getData());
        for(Carrinho carrinho: pedido.getCarrinho()) {
            Carrinho processado = new Carrinho();
            this.carrinho.add(processado);
        }
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Carrinho> getProdutos() {
		return carrinho;
	}
	public void setProdutos(List<Carrinho> produtos) {
		this.carrinho = produtos;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
	
}
