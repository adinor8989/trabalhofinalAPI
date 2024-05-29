package br.com.ecommerce.controller;

import br.com.ecommerce.dto.ClienteRequestDTO;
import br.com.ecommerce.dto.ClienteResponseDTO;
import br.com.ecommerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> getAllClientes() {
        List<ClienteResponseDTO> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> getClienteById(@PathVariable Long id) {
        ClienteResponseDTO cliente = clienteService.getClienteById(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> createCliente(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        ClienteResponseDTO createdCliente = clienteService.createCliente(clienteRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCliente);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteRequestDTO clienteRequestDTO) {
        ClienteResponseDTO cliente = clienteService.updateCliente(id, clienteRequestDTO);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}