package br.com.ecommerce.service;

import java.util.List;
import java.util.Optional;
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

	public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO cliente) {
		Optional<Cliente> optionalCliente = repository.findById(id);
        if (optionalCliente.isPresent()) {
            Cliente cliente1 = optionalCliente.get();
            cliente1.setNome(cliente1.getNome());
            cliente1.setEmail(cliente1.getEmail());
            Cliente clienteAtualizado = repository.save(cliente1);
            return new ClienteResponseDTO(clienteAtualizado);
        } else {
        	return null;
        }
	}	
	public boolean deletar(Long id) {
	    Optional<Cliente> optionalCliente = repository.findById(id);
	    if (optionalCliente.isPresent()) {
	        repository.deleteById(id);
	        return true;
	    } else {
	        return false;
	    }
	}
}
