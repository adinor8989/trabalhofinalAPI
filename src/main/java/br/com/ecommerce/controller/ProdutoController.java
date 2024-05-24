package br.com.ecommerce.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ecommerce.entity.Produto;
import br.com.ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping("{id}")
	public ResponseEntity<Optional<Produto>> buscarid(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscarProduto(id));
	}
	
	
	@PostMapping
    public ResponseEntity<Produto> inserir(@RequestBody Produto produto) {
        Produto u = service.inserirProduto(produto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(u.getId())
            .toUri();
        return ResponseEntity.created(location).body(u);
    }
	
}
