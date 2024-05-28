package br.com.ecommerce.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.ecommerce.entity.Carrinho;
import br.com.ecommerce.entity.Pedido;
import br.com.ecommerce.enums.PedidoStatus;

public class PedidoResponseDTO {

	private Long id;
	private LocalDate data;
	private PedidoStatus status;
	
	public PedidoResponseDTO(Pedido pedido) {
		this.id = pedido.getId();
		this.status = pedido.getStatus();
		this.setData(pedido.getData());
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PedidoStatus getStatus() {
		return status;
	}

	public void setStatus(PedidoStatus status) {
		this.status = status;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

}
