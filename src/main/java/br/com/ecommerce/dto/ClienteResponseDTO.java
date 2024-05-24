package br.com.ecommerce.dto;


import br.com.ecommerce.entity.Cliente;

public class ClienteResponseDTO {

	private Long id;
	private String nome;
	private String email;
	

	public ClienteResponseDTO() {
	
    }
	public ClienteResponseDTO(Cliente c) {
		this.id = c.getId();
		this.nome = c.getNome();
		this.email = c.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
