package br.com.ecommerce.service;

import java.util.List;
<<<<<<< HEAD
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
=======
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
>>>>>>> da21fd7040492f75c32ddf25b0033cd290c681f9

import br.com.ecommerce.dto.ClienteRequestDTO;
import br.com.ecommerce.dto.ClienteResponseDTO;
import br.com.ecommerce.entity.Cliente;
import br.com.ecommerce.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

<<<<<<< HEAD
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
=======
	private final ClienteRepository clienteRepository;

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

	public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO cliente) {
		Optional<Cliente> optionalCliente = clienteRepository.findById(id);
		if (optionalCliente.isPresent()) {
			Cliente cliente1 = optionalCliente.get();
			cliente1.setNome(cliente1.getNome());
			cliente1.setEmail(cliente1.getEmail());
			Cliente clienteAtualizado = clienteRepository.save(cliente1);
			return new ClienteResponseDTO(clienteAtualizado);
		} else {
			return null;
		}
	}

	public boolean deletar(Long id) {
		Optional<Cliente> optionalCliente = clienteRepository.findById(id);
		if (optionalCliente.isPresent()) {
			clienteRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
>>>>>>> da21fd7040492f75c32ddf25b0033cd290c681f9
}