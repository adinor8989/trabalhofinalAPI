package br.com.ecommerce.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.ecommerce.enums.PedidoStatus;

public class PedidoRequestDTO {

	private PedidoStatus status;
	private LocalDate data;
	private Double total;
	private Long idCliente;
	private List<CarrinhoDTO> carrinho;

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

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public List<CarrinhoDTO> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(List<CarrinhoDTO> carrinho) {
		this.carrinho = carrinho;
	}

	public static class CarrinhoDTO {
		private Long id;
		private Integer quantidade;
		private Double valorVenda;
		private Double subTotal;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Integer getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(Integer quantidade) {
			this.quantidade = quantidade;
		}

		public Double getValorVenda() {
			return valorVenda;
		}

		public void setValorVenda(Double valorVenda) {
			this.valorVenda = valorVenda;
		}

		public Double getSubTotal() {
			return subTotal;
		}

		public void setSubTotal(Double subTotal) {
			this.subTotal = subTotal;
		}
	}
}
