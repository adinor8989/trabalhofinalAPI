package br.com.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.dto.ClienteRequestDTO;
import br.com.ecommerce.dto.ClienteResponseDTO;
import br.com.ecommerce.entity.Cliente;
import br.com.ecommerce.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	public List<ClienteResponseDTO> listar(){
		List<Cliente> clientess = repository.findAll();
		return clientess.stream().map((c) -> new ClienteResponseDTO(c)).collect(Collectors.toList());
	}

	public ClienteResponseDTO inserir(ClienteRequestDTO  clientes) {
		ClienteResponseDTO u = new ClienteResponseDTO();
		u.setEmail(clientes.getEmail());
		u.setNome(clientes.getNome());
		return u;
	}
	
	
}
