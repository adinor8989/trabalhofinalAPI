package br.com.ecommerce.dto;

import java.util.HashSet;
import java.util.Set;

import br.com.ecommerce.entity.Cliente;

public class ClienteRequestDTO {
	
	private String nome;
	private String email;
	private String telefone;
	private String cep;
	
	private Set<Cliente> clientes = new HashSet<>();

	public ClienteRequestDTO() {
	}
	public ClienteRequestDTO(String nome, String email, String telefone, String cep, Set<Cliente> clientes) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cep = cep;
		this.clientes = clientes;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}
}
