package br.com.ecommerce.dto;

import java.util.HashSet;
import java.util.Set;

import br.com.ecommerce.entity.Cliente;

public class ClienteResponseDTO {

	private Long id;
	private String nome;
	private String email;
	
	private Set<Cliente> clientes = new HashSet<>();

	public ClienteResponseDTO(Long id, String nome, String email, Set<Cliente> clientes) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.clientes = clientes;
	}

	public ClienteResponseDTO(Cliente c) {
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

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}
}
