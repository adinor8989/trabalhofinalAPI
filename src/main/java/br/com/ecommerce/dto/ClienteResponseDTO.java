package br.com.ecommerce.dto;

import br.com.ecommerce.entity.Cliente;

public class ClienteResponseDTO {

	private String nome;
	private String email;

	public ClienteResponseDTO(Long id, String nome, String email) {
		this.nome = nome;
		this.email = email;

	}

	public ClienteResponseDTO() {
	}

	public ClienteResponseDTO(Cliente c) {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
