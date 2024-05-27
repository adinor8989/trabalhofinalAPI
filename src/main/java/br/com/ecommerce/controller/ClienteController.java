package br.com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping
	public List<ClienteResponseDTO> listar() {
		return service.listar();
	}

	@PostMapping
	public ResponseEntity<ClienteResponseDTO> inserir(@RequestBody ClienteRequestDTO cliente) {
		return ResponseEntity.created(null).body(service.inserir(cliente));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable Long id,
			@RequestBody ClienteRequestDTO clienteRequestDTO) {
		ClienteResponseDTO clienteAtualizado = service.atualizar(id, clienteRequestDTO);
		if (clienteAtualizado != null) {
			return ResponseEntity.ok(clienteAtualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar (@PathVariable Long id){
		boolean deletado = service.deletar(id);
		if (deletado) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}