package br.com.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.dto.ProdutoRequestDTO;
import br.com.ecommerce.dto.ProdutoResponseDTO;
import br.com.ecommerce.entity.Produto;
import br.com.ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<ProdutoResponseDTO>> buscar() {
		return ResponseEntity.ok(service.buscarProduto());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ProdutoResponseDTO> buscarid(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscarProduto(id));
	}
	
			
	@PostMapping
	public ResponseEntity<ProdutoResponseDTO> inserir(@RequestBody ProdutoRequestDTO produto) {
		return new ResponseEntity<>(service.inserirProduto(produto),HttpStatus.OK);
	}
	
}
