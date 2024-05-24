package br.com.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.configuration.MailConfig;
import br.com.ecommerce.dto.ClienteRequestDTO;
import br.com.ecommerce.dto.ClienteResponseDTO;
import br.com.ecommerce.entity.Cliente;
import br.com.ecommerce.entity.Endereco;
import br.com.ecommerce.repository.ClienteRepository;
import jakarta.mail.MessagingException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
    private MailConfig emailService;
	
	public List<ClienteResponseDTO> listar(){
		List<Cliente> clientes = repository.findAll();
		return clientes.stream().map((c) -> new ClienteResponseDTO(c)).collect(Collectors.toList());
	}

	public ClienteResponseDTO inserir(ClienteRequestDTO clientes) {
        Cliente cliente = new Cliente();
        cliente.setNome(clientes.getNome());
        cliente.setCpf(clientes.getCpf());
        cliente.setEmail(clientes.getEmail());
        cliente.setTelefone(clientes.getTelefone());
        cliente.setCep(clientes.getCep());
        Cliente clienteSalvo = repository.save(cliente);
              
        ClienteResponseDTO response = new ClienteResponseDTO(clienteSalvo);
        
        return response;
    }
	
	public ClienteResponseDTO editar(Long id, ClienteResponseDTO clienteDTO) throws MessagingException {
        Cliente cliente = repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        Cliente clienteEditado = repository.save(cliente);
        emailService.sendMail(clienteEditado.getEmail(), "Atualização de cadastro", "Seu cadastro foi atualizado com sucesso.");
        
        return new ClienteResponseDTO(clienteEditado);
    }
	
	
	
}
