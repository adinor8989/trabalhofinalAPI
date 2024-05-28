package br.com.ecommerce.dto;

import br.com.ecommerce.entity.Categoria;
import br.com.ecommerce.entity.Produto;

public class ProdutoResponseDTO {

	private Long id;
	private String nome;
	private Categoria categoria;

	public ProdutoResponseDTO() {
		super();
	}

	public ProdutoResponseDTO(Produto p) {
		super();
		this.id = p.getId();
		this.nome = p.getNome();
		this.categoria = p.getCategoria();
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
