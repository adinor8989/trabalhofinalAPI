package br.com.ecommerce.enums;

public enum ClientePatente {
	BRONZE(1,"Bronze"),PRATA(2,"Prata"),OURO(3,"Ouro");

	private Integer codigo;
	private String tipo;
	
	private ClientePatente(Integer codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
