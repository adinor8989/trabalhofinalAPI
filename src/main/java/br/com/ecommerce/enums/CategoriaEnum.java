package br.com.ecommerce.enums;

public enum CategoriaEnum {

	CASACO(1, "Casaco"), CALCA(2, "Calça"), BLUSA(3, "Blusa"), CAMISETA(4, "Camisete");
	
	private Integer codigo;
	private String nome;
	
	private CategoriaEnum(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
}
