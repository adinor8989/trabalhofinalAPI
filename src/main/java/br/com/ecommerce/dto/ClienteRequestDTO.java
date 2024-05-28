package br.com.ecommerce.dto;

import java.util.Set;

import br.com.ecommerce.entity.Cliente;

public class ClienteRequestDTO {
	private String nome;
	private String email;
	private String telefone;
	private String cep;
	private String cpf;

	public ClienteRequestDTO() {
	}

	public ClienteRequestDTO(String nome, String email, String telefone, String cep, String cpf,
			Set<Cliente> clientes) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cep = cep;
		this.cpf = cpf;

	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

}
