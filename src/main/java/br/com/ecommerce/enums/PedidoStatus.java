package br.com.ecommerce.enums;

public enum PedidoStatus {
	PENDENTE(1, "Pendente"), PROCESSANDO(2, "Processando"), ENVIADO(3, "Enviado"), ENTREGUE(4, "Entregue");

	private Integer codigo;
	private String nome;

	private PedidoStatus(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
