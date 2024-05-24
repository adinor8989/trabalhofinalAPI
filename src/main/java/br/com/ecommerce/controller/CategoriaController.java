package br.com.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.entity.Categoria;
import br.com.ecommerce.service.CategoriaService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping("{id}")
	public ResponseEntity<Categoria> buscarporid(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscarid(id));
	}
	
		
	@PostMapping
	public ResponseEntity<Categoria> inserir(@RequestBody Categoria categoria) {
		Categoria u = service.inserirCategoria(categoria);
		return ResponseEntity.created(null).body(u);
	}
	
	
	
}
