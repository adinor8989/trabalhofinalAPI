package br.com.ecommerce.dto;

public class CarrinhoRequestDTO {
      
	private Long idProduto;
    private Long idPedido;
    private Integer quantidade;
    private Double valor;
            
	public CarrinhoRequestDTO() {
		super();
	}
	public CarrinhoRequestDTO(Long idProduto, Long idPedido, Integer quantidade, Double valor) {
		super();
		this.idProduto = idProduto;
		this.idPedido = idPedido;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
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
