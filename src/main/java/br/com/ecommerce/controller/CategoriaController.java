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

import br.com.ecommerce.entity.Categoria;
import br.com.ecommerce.service.CategoriaService;
import jakarta.persistence.EntityNotFoundException;



@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> buscar() {
		return ResponseEntity.ok(service.buscar());
	}
		
	@GetMapping("{id}")
	public ResponseEntity<Categoria> buscarporid(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscarid(id));
	}
	
		
	@PostMapping
	public ResponseEntity<Categoria> inserir(@RequestBody Categoria categoria) {
		Categoria u = service.inserirCategoria(categoria);
		return ResponseEntity.created(null).body(u);
	}
	
	@PutMapping("/categorias/{id}")
    public ResponseEntity<Categoria> alterarCategoria(@RequestBody Categoria categoria, @PathVariable Long id) {
        try {
            Categoria categoriaAtualizada = service.alterarCategoria(categoria, id);
            return ResponseEntity.ok(categoriaAtualizada);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
	
	
}
