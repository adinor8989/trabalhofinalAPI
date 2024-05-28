package br.com.ecommerce.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ecommerce.dto.PedidoResponseDTO;
import br.com.ecommerce.entity.Pedido;
import br.com.ecommerce.entity.Produto;
import br.com.ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscar() {
		return ResponseEntity.ok(service.buscarProduto());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Optional<Produto>> buscarid(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscarProduto(id));
	}
	
			
	@PostMapping
	public ResponseEntity<Produto> inserir(@RequestBody Produto produto) {
		return service.inserirProduto(produto);
	}
	
}
