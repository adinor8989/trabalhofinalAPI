package br.com.ecommerce.dto;


import br.com.ecommerce.entity.Produto;

public class ProdutoResponseDTO {

	private Long id;
	private String nome;
	private String nomeCategoria;

	public ProdutoResponseDTO() {
		super();
	}

	public ProdutoResponseDTO(Produto p) {
		super();
		this.id = p.getId();
		this.nome = p.getNome();
		this.nomeCategoria = p.getCategoria().getNome();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	

}
