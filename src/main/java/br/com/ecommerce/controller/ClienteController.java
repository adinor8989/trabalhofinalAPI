package br.com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.dto.ClienteRequestDTO;
import br.com.ecommerce.dto.ClienteResponseDTO;
import br.com.ecommerce.service.ClienteService;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping
	public List<ClienteResponseDTO> listar() {
		return service.listar();
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> editar(@PathVariable Long id, @RequestBody ClienteResponseDTO clienteDTO) throws MessagingException {
        ClienteResponseDTO cliente= service.editar(id, clienteDTO);
        return ResponseEntity.ok(cliente);
    }

	@PostMapping
	public ResponseEntity<ClienteResponseDTO> inserir(@RequestBody ClienteRequestDTO cliente) {
     	return ResponseEntity.created(null).body(service.inserir(cliente));
}
}