package br.com.ecommerce.dto;

<<<<<<< HEAD
=======
import java.util.HashSet;
import java.util.Set;

import br.com.ecommerce.entity.Cliente;

>>>>>>> cd8099e92e3f0bca65aa1d9bd38818b98b0078e7
public class ClienteRequestDTO {
	private String nome;
	private String email;
	private String telefone;
	private String cep;
	private String cpf;
	
	private Set<Cliente> clientes = new HashSet<>();

	public ClienteRequestDTO() {
	}
	public ClienteRequestDTO(String nome, String email, String telefone, String cep,String cpf, Set<Cliente> clientes) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cep = cep;
		this.cpf = cpf;
		this.clientes = clientes;
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

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

}
