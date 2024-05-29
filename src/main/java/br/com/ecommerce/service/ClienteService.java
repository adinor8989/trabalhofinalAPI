package br.com.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.ecommerce.dto.ClienteRequestDTO;
import br.com.ecommerce.dto.ClienteResponseDTO;
import br.com.ecommerce.entity.Cliente;
import br.com.ecommerce.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public List<ClienteResponseDTO> getAllClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes.stream().map(this::convertToResponseDTO).collect(Collectors.toList());
	}

	public ClienteResponseDTO getClienteById(Long id) {
		Cliente cliente = clienteRepository.findById(id).orElse(null);
		if (cliente != null) {
			return convertToResponseDTO(cliente);
		} else {
			return null;
		}
	}

	public ClienteResponseDTO createCliente(ClienteRequestDTO clienteRequestDTO) {
		Cliente cliente = new Cliente();
		BeanUtils.copyProperties(clienteRequestDTO, cliente);
		cliente = clienteRepository.save(cliente);
		return convertToResponseDTO(cliente);
	}

	private ClienteResponseDTO convertToResponseDTO(Cliente cliente) {
		return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getEmail());
	}
	public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

	public ClienteResponseDTO updateCliente(Long id, ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            BeanUtils.copyProperties(clienteRequestDTO, cliente);
            cliente = clienteRepository.save(cliente);
            return convertToResponseDTO(cliente);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }
    }
}